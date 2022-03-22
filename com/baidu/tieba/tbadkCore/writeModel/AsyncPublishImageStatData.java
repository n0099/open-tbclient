package com.baidu.tieba.tbadkCore.writeModel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AsyncPublishImageStatData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int compressHeight;
    public long compressSize;
    public String compressTempPath;
    public int compressWidth;
    public long endCompressTime;
    public long endTime;
    public int errorCode;
    public String errorMessage;
    public boolean hasActionsWithoutResize;
    public boolean isHeifImage;
    public boolean isLongImage;
    public int originHeight;
    public String originPath;
    public long originSize;
    public int originWidth;
    public String picId;
    public long startCompressTime;
    public long startTime;
    public long uploadDuration;
    public String uploadImageType;
    public float uploadRate;

    public AsyncPublishImageStatData(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageFileInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        imageFileInfo.startUploadTime = currentTimeMillis;
        this.startTime = currentTimeMillis;
    }

    public JSONObject toJson() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FetchLog.START_TIME, this.startTime);
            jSONObject.put(FetchLog.END_TIME, this.endTime);
            jSONObject.put("uploadRate", this.uploadRate);
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("errorMessage", this.errorMessage);
            jSONObject.put("picId", this.picId);
            jSONObject.put("originPath", this.originPath);
            jSONObject.put("originSize", this.originSize);
            jSONObject.put("originWidth", this.originWidth);
            jSONObject.put("originHeight", this.originHeight);
            jSONObject.put("isLongImage", this.isLongImage);
            jSONObject.put("isHeifImage", this.isHeifImage);
            jSONObject.put("startCompressTime", this.startCompressTime);
            jSONObject.put("endCompressTime", this.endCompressTime);
            jSONObject.put("hasActionsWithoutResize", this.hasActionsWithoutResize);
            jSONObject.put("uploadImageType", this.uploadImageType);
            jSONObject.put("compressTempPath", this.compressTempPath);
            jSONObject.put("compressWidth", this.compressWidth);
            jSONObject.put("compressHeight", this.compressHeight);
            jSONObject.put("compressSize", this.compressSize);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public AsyncPublishImageStatData(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.startTime = System.currentTimeMillis();
        this.originPath = str;
    }
}
