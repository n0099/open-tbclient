package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.LowVersionLoginPassV6Switch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t89() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                b(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("switch")) != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("name");
                        Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", 0));
                        if (LoginPassV6Switch.KEY.equals(optString)) {
                            SwitchManager.getInstance().turn(optString, valueOf.intValue());
                            zc5.a();
                        }
                        if (TextUtils.equals(LowVersionLoginPassV6Switch.KEY, optString)) {
                            SwitchManager.getInstance().turn(optString, valueOf.intValue());
                            zc5.a();
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
