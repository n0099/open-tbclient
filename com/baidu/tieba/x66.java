package com.baidu.tieba;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ArrayList<SdkLiveInfoData> b;

    public x66() {
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
        this.a = false;
    }

    public void a(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, jSONObject, str) != null) || jSONObject == null) {
            return;
        }
        boolean z = true;
        if (jSONObject.optInt("has_more") != 1) {
            z = false;
        }
        this.a = z;
        JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.b = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                    sdkLiveInfoData.fromJson(optJSONObject, str);
                    this.b.add(sdkLiveInfoData);
                }
            }
        }
    }
}
