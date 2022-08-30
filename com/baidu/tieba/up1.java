package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.h03;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class up1 extends tp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public at1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new at1(1001, "context not support");
            }
            j02 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new at1(1001, "none fragmentManger");
            }
            g02 m = X.m();
            if (!(m instanceof h03.a)) {
                return new at1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new at1(1001, "fragment has detached");
            }
            i03.c(m);
            ay1.i("LoadingViewApi", "hide loading success");
            return at1.f();
        }
        return (at1) invokeV.objValue;
    }

    public at1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                ay1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new at1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                ay1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new at1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new at1(1001, "context not support");
                }
                j02 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new at1(1001, "none fragment");
                }
                g02 m = X.m();
                if (!(m instanceof h03.a)) {
                    return new at1(1001, "fragment not support");
                }
                h03 d = ((h03.a) m).d();
                if (d == null) {
                    return new at1(1001, "can't get floatLayer");
                }
                i03.f(d, context, optString, optBoolean);
                ay1.i("LoadingViewApi", "show loading success");
                return at1.f();
            }
            return at1Var;
        }
        return (at1) invokeL.objValue;
    }
}
