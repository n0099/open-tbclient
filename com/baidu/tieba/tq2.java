package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tq2 extends sq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wq2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RequestDescInterceptor" : (String) invokeV.objValue;
    }

    public tq2() {
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

    @Override // com.baidu.tieba.wq2
    public boolean enable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return sv1.h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wq2
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (SchemeCollecter.CLASSIFY_SWAN_V8.equals(str) && "request".equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.wq2
    @NonNull
    public JSONObject c(@NonNull String str, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject)) == null) {
            try {
                jSONObject.put(DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "swan.method.v8BindingObject");
                jSONObject.put("method", "_naSwan.naRequest");
                JSONArray optJSONArray = jSONObject.optJSONArray(WebChromeClient.KEY_ARG_ARRAY);
                if (optJSONArray != null) {
                    List asList = Arrays.asList("cb", "ping", "__requestDataType__");
                    for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(length);
                        if (optJSONObject != null && asList.contains(optJSONObject.optString("name"))) {
                            optJSONArray.remove(length);
                        }
                    }
                    optJSONArray.put(d("success", "function="));
                    optJSONArray.put(d("fail", "function="));
                    optJSONArray.put(d(TaskProcessData.keyComplete, "function="));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
