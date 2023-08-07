package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.fa3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sz1 extends rz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz1(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public y22 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new y22(1001, "context not support");
            }
            ha2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new y22(1001, "none fragmentManger");
            }
            ea2 m = Y.m();
            if (!(m instanceof fa3.a)) {
                return new y22(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new y22(1001, "fragment has detached");
            }
            ga3.c(m);
            y72.i("LoadingViewApi", "hide loading success");
            return y22.f();
        }
        return (y22) invokeV.objValue;
    }

    public y22 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                y72.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new y22(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            y72.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new y22(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new y22(1001, "context not support");
            }
            ha2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new y22(1001, "none fragment");
            }
            ea2 m = Y.m();
            if (!(m instanceof fa3.a)) {
                return new y22(1001, "fragment not support");
            }
            fa3 floatLayer = ((fa3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new y22(1001, "can't get floatLayer");
            }
            ga3.f(floatLayer, context, optString, optBoolean);
            y72.i("LoadingViewApi", "show loading success");
            return y22.f();
        }
        return (y22) invokeL.objValue;
    }
}
