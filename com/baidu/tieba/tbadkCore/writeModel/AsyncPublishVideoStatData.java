package com.baidu.tieba.tbadkCore.writeModel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AsyncPublishVideoStatData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int duration;
    public long endTime;
    public int errorCode;
    public String errorMessage;
    public String md5;
    public String path;
    public long size;
    public long startTime;
    public String url;

    public AsyncPublishVideoStatData(@NonNull VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.startTime = System.currentTimeMillis();
        this.path = videoInfo.getVideoPath();
        this.duration = videoInfo.getVideoDuration();
    }

    public JSONObject toJson() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.startTime);
            jSONObject.put("endTime", this.endTime);
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("errorMessage", this.errorMessage);
            jSONObject.put(PackageTable.MD5, this.md5);
            jSONObject.put("url", this.url);
            jSONObject.put("path", this.path);
            jSONObject.put("duration", this.duration);
            jSONObject.put("size", this.size);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
