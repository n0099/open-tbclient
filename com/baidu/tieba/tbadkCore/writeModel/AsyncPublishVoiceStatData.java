package com.baidu.tieba.tbadkCore.writeModel;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class AsyncPublishVoiceStatData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long endTime;
    public int errorCode;
    public String errorMessage;
    public String id;
    public String md5;
    public long size;
    public long startTime;

    public AsyncPublishVoiceStatData(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.startTime = System.currentTimeMillis();
        this.id = str;
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
            jSONObject.put("id", this.id);
            jSONObject.put("size", this.size);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
