package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.a73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nw1 extends mw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public tz1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new tz1(1001, "context not support");
            }
            c72 Z = ((SwanAppActivity) context).Z();
            if (Z == null) {
                return new tz1(1001, "none fragmentManger");
            }
            z62 m = Z.m();
            if (!(m instanceof a73.a)) {
                return new tz1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new tz1(1001, "fragment has detached");
            }
            b73.c(m);
            t42.i("LoadingViewApi", "hide loading success");
            return tz1.f();
        }
        return (tz1) invokeV.objValue;
    }

    public tz1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                t42.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new tz1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<tz1, JSONObject> s = s(str);
            tz1 tz1Var = (tz1) s.first;
            if (!tz1Var.isSuccess()) {
                return tz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            t42.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new tz1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new tz1(1001, "context not support");
            }
            c72 Z = ((SwanAppActivity) context).Z();
            if (Z == null) {
                return new tz1(1001, "none fragment");
            }
            z62 m = Z.m();
            if (!(m instanceof a73.a)) {
                return new tz1(1001, "fragment not support");
            }
            a73 d = ((a73.a) m).d();
            if (d == null) {
                return new tz1(1001, "can't get floatLayer");
            }
            b73.f(d, context, optString, optBoolean);
            t42.i("LoadingViewApi", "show loading success");
            return tz1.f();
        }
        return (tz1) invokeL.objValue;
    }
}
