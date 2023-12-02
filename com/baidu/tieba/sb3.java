package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sb3 extends vb3<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    public sb3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hb3
    /* renamed from: Q */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            return ib3.c(jSONObject);
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vb3
    public HttpRequest x(vb3 vb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vb3Var)) == null) {
            return rp2.o().g(this.m, vb3Var.C());
        }
        return (HttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vb3
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return SwanInterfaceType.SWAN_ID;
        }
        return (SwanInterfaceType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb3
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            k63 M = k63.M();
            if (M != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", M.P());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                w("data", jSONObject.toString());
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
