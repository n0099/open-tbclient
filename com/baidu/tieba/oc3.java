package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oc3 implements nc3<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray b;

    public oc3() {
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
        this.b = new JSONArray();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new JSONArray();
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchLog", this.b);
            } catch (JSONException e) {
                if (nc3.a) {
                    Log.e("LaunchTraceCollector", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                if (nc3.a) {
                    Log.d("LaunchTraceCollector", "event is empty");
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("actionId", str);
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                jSONObject.put("info", str2);
                b(jSONObject);
            } catch (JSONException e) {
                if (nc3.a) {
                    Log.w("LaunchTraceCollector", Log.getStackTraceString(e));
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && jSONObject != null) {
            this.b.put(jSONObject);
        }
    }
}
