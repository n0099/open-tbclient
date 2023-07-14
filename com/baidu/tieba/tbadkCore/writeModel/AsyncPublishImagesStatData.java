package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AsyncPublishImagesStatData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long endTime;
    public int errorCode;
    public String errorMessage;
    public Map<Long, AsyncPublishImageStatData> imageInfo;
    public long startTime;

    public AsyncPublishImagesStatData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.imageInfo = new HashMap();
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
            if (this.imageInfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (AsyncPublishImageStatData asyncPublishImageStatData : this.imageInfo.values()) {
                    jSONArray.put(asyncPublishImageStatData.toJson());
                }
                jSONObject.put("imageInfo", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
