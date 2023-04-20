package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.c73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pw1 extends ow1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw1(@NonNull wv1 wv1Var) {
        super(wv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public vz1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new vz1(1001, "context not support");
            }
            e72 Z = ((SwanAppActivity) context).Z();
            if (Z == null) {
                return new vz1(1001, "none fragmentManger");
            }
            b72 m = Z.m();
            if (!(m instanceof c73.a)) {
                return new vz1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new vz1(1001, "fragment has detached");
            }
            d73.c(m);
            v42.i("LoadingViewApi", "hide loading success");
            return vz1.f();
        }
        return (vz1) invokeV.objValue;
    }

    public vz1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                v42.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new vz1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<vz1, JSONObject> s = s(str);
            vz1 vz1Var = (vz1) s.first;
            if (!vz1Var.isSuccess()) {
                return vz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            v42.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new vz1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new vz1(1001, "context not support");
            }
            e72 Z = ((SwanAppActivity) context).Z();
            if (Z == null) {
                return new vz1(1001, "none fragment");
            }
            b72 m = Z.m();
            if (!(m instanceof c73.a)) {
                return new vz1(1001, "fragment not support");
            }
            c73 d = ((c73.a) m).d();
            if (d == null) {
                return new vz1(1001, "can't get floatLayer");
            }
            d73.f(d, context, optString, optBoolean);
            v42.i("LoadingViewApi", "show loading success");
            return vz1.f();
        }
        return (vz1) invokeL.objValue;
    }
}
