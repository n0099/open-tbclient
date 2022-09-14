package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.f23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sr1 extends rr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sr1(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zq1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public yu1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new yu1(1001, "context not support");
            }
            h22 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new yu1(1001, "none fragmentManger");
            }
            e22 m = X.m();
            if (!(m instanceof f23.a)) {
                return new yu1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new yu1(1001, "fragment has detached");
            }
            g23.c(m);
            yz1.i("LoadingViewApi", "hide loading success");
            return yu1.f();
        }
        return (yu1) invokeV.objValue;
    }

    public yu1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                yz1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new yu1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                yz1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new yu1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new yu1(1001, "context not support");
                }
                h22 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new yu1(1001, "none fragment");
                }
                e22 m = X.m();
                if (!(m instanceof f23.a)) {
                    return new yu1(1001, "fragment not support");
                }
                f23 d = ((f23.a) m).d();
                if (d == null) {
                    return new yu1(1001, "can't get floatLayer");
                }
                g23.f(d, context, optString, optBoolean);
                yz1.i("LoadingViewApi", "show loading success");
                return yu1.f();
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }
}
