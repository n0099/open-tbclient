package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.m33;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zs1 extends ys1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fw1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new fw1(1001, "context not support");
            }
            o32 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new fw1(1001, "none fragmentManger");
            }
            l32 m = X.m();
            if (!(m instanceof m33.a)) {
                return new fw1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new fw1(1001, "fragment has detached");
            }
            n33.c(m);
            f12.i("LoadingViewApi", "hide loading success");
            return fw1.f();
        }
        return (fw1) invokeV.objValue;
    }

    public fw1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                f12.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new fw1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            f12.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new fw1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new fw1(1001, "context not support");
            }
            o32 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new fw1(1001, "none fragment");
            }
            l32 m = X.m();
            if (!(m instanceof m33.a)) {
                return new fw1(1001, "fragment not support");
            }
            m33 d = ((m33.a) m).d();
            if (d == null) {
                return new fw1(1001, "can't get floatLayer");
            }
            n33.f(d, context, optString, optBoolean);
            f12.i("LoadingViewApi", "show loading success");
            return fw1.f();
        }
        return (fw1) invokeL.objValue;
    }
}
