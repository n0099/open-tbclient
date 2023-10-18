package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.w43;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ku1 extends ju1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ku1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qx1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideLoading", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new qx1(1001, "context not support");
            }
            y42 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new qx1(1001, "none fragmentManger");
            }
            v42 m = Y.m();
            if (!(m instanceof w43.a)) {
                return new qx1(1001, "fragment not support");
            }
            if (m.s() == null) {
                return new qx1(1001, "fragment has detached");
            }
            x43.c(m);
            p22.i("LoadingViewApi", "hide loading success");
            return qx1.f();
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#showLoading", false);
            if (o()) {
                p22.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new qx1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            p22.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new qx1(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context i = i();
            if (!(i instanceof SwanAppActivity)) {
                return new qx1(1001, "context not support");
            }
            y42 Y = ((SwanAppActivity) i).Y();
            if (Y == null) {
                return new qx1(1001, "none fragment");
            }
            v42 m = Y.m();
            if (!(m instanceof w43.a)) {
                return new qx1(1001, "fragment not support");
            }
            w43 floatLayer = ((w43.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new qx1(1001, "can't get floatLayer");
            }
            x43.f(floatLayer, i, optString, optBoolean);
            p22.i("LoadingViewApi", "show loading success");
            return qx1.f();
        }
        return (qx1) invokeL.objValue;
    }
}
