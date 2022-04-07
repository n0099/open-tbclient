package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AsyncPublishStatData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long endTime;
    public int errorCode;
    public String errorMessage;
    public int haveImage;
    public int haveVideo;
    public int haveVoice;
    public long id;
    public int imageChunkRetry;
    public int imageChunkSize;
    public int imageCount;
    public int imageErrorCode;
    public String imageErrorMessage;
    public long imageSize;
    public int imageUploadConcurrency;
    public long imageUploadDuration;
    public float imageUploadRate;
    public AsyncPublishImagesStatData imagesData;
    public int needImageParallel;
    public long parentId;
    public long sendThreadDuration;
    public long startTime;
    public AsyncPublishVideoStatData videoData;
    public int videoErrorCode;
    public String videoErrorMessage;
    public AsyncPublishImageStatData videoFirstFrame;
    public long videoSize;
    public long videoUploadDuration;
    public float videoUploadRate;
    public AsyncPublishVoiceStatData voiceData;
    public int voiceErrorCode;
    public String voiceErrorMessage;
    public long voiceSize;
    public long voiceUploadDuration;
    public float voiceUploadRate;

    public AsyncPublishStatData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (writeData != null && writeData.startPublishTime() > 0) {
            AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
            if (asyncPublishStatData != null) {
                long j = asyncPublishStatData.parentId;
                if (j > 0) {
                    this.parentId = j;
                } else {
                    this.parentId = asyncPublishStatData.id;
                }
            }
            this.id = writeData.startPublishTime();
            this.startTime = writeData.startPublishTime();
            return;
        }
        throw new RuntimeException("writeData must is async mode(has startPublishTime)");
    }

    public JSONObject toClickStatJson() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.id);
            jSONObject.put("parentId", this.parentId);
            jSONObject.put(FetchLog.START_TIME, this.startTime);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject toEndStatJson() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.id);
            jSONObject.put("parentId", this.parentId);
            jSONObject.put(FetchLog.START_TIME, this.startTime);
            jSONObject.put(FetchLog.END_TIME, this.endTime);
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("errorMessage", this.errorMessage);
            jSONObject.put("sendThreadDuration", this.sendThreadDuration);
            jSONObject.put("haveImage", this.haveImage);
            jSONObject.put("haveVideo", this.haveVideo);
            jSONObject.put("haveVoice", this.haveVoice);
            AsyncPublishImagesStatData asyncPublishImagesStatData = this.imagesData;
            if (asyncPublishImagesStatData != null) {
                jSONObject.put("imagesData", asyncPublishImagesStatData.toJson());
                jSONObject.put("imageErrorCode", this.imageErrorCode);
                jSONObject.put("imageErrorMessage", this.imageErrorMessage);
                jSONObject.put("imageUploadRate", this.imageUploadRate);
                jSONObject.put("imageUploadDuration", this.imageUploadDuration);
                jSONObject.put("imageCount", this.imageCount);
                jSONObject.put("imageSize", this.imageSize);
                jSONObject.put("needImageParallel", this.needImageParallel);
                jSONObject.put("imageChunkSize", this.imageChunkSize);
                jSONObject.put("imageUploadConcurrency", this.imageUploadConcurrency);
                jSONObject.put("imageChunkRetry", this.imageChunkRetry);
            }
            AsyncPublishVoiceStatData asyncPublishVoiceStatData = this.voiceData;
            if (asyncPublishVoiceStatData != null) {
                jSONObject.put("voiceData", asyncPublishVoiceStatData.toJson());
                jSONObject.put("voiceErrorCode", this.voiceErrorCode);
                jSONObject.put("voiceErrorMessage", this.voiceErrorMessage);
                jSONObject.put("voiceUploadRate", this.voiceUploadRate);
                jSONObject.put("voiceUploadDuration", this.voiceUploadDuration);
                jSONObject.put("voiceSize", this.voiceSize);
            }
            AsyncPublishVideoStatData asyncPublishVideoStatData = this.videoData;
            if (asyncPublishVideoStatData != null) {
                jSONObject.put("videoData", asyncPublishVideoStatData.toJson());
                jSONObject.put("videoErrorCode", this.videoErrorCode);
                jSONObject.put("videoErrorMessage", this.videoErrorMessage);
                jSONObject.put("videoUploadRate", this.videoUploadRate);
                jSONObject.put("videoUploadDuration", this.videoUploadDuration);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.videoSize);
            }
            AsyncPublishImageStatData asyncPublishImageStatData = this.videoFirstFrame;
            if (asyncPublishImageStatData != null) {
                jSONObject.put("videoFirstFrame", asyncPublishImageStatData.toJson());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
