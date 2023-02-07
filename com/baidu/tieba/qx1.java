package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.d83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qx1 extends px1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx1(@NonNull xw1 xw1Var) {
        super(xw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xw1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xw1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public w02 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new w02(1001, "context not support");
            }
            f82 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new w02(1001, "none fragmentManger");
            }
            c82 m = X.m();
            if (!(m instanceof d83.a)) {
                return new w02(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new w02(1001, "fragment has detached");
            }
            e83.c(m);
            w52.i("LoadingViewApi", "hide loading success");
            return w02.f();
        }
        return (w02) invokeV.objValue;
    }

    public w02 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                w52.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new w02(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<w02, JSONObject> s = s(str);
            w02 w02Var = (w02) s.first;
            if (!w02Var.isSuccess()) {
                return w02Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            w52.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new w02(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new w02(1001, "context not support");
            }
            f82 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new w02(1001, "none fragment");
            }
            c82 m = X.m();
            if (!(m instanceof d83.a)) {
                return new w02(1001, "fragment not support");
            }
            d83 d = ((d83.a) m).d();
            if (d == null) {
                return new w02(1001, "can't get floatLayer");
            }
            e83.f(d, context, optString, optBoolean);
            w52.i("LoadingViewApi", "show loading success");
            return w02.f();
        }
        return (w02) invokeL.objValue;
    }
}
