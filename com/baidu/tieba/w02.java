package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.jb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w02 extends v02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w02(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c42 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new c42(1001, "context not support");
            }
            lb2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new c42(1001, "none fragmentManger");
            }
            ib2 m = Y.m();
            if (!(m instanceof jb3.a)) {
                return new c42(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new c42(1001, "fragment has detached");
            }
            kb3.c(m);
            c92.i("LoadingViewApi", "hide loading success");
            return c42.f();
        }
        return (c42) invokeV.objValue;
    }

    public c42 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                c92.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new c42(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            c92.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new c42(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new c42(1001, "context not support");
            }
            lb2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new c42(1001, "none fragment");
            }
            ib2 m = Y.m();
            if (!(m instanceof jb3.a)) {
                return new c42(1001, "fragment not support");
            }
            jb3 floatLayer = ((jb3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new c42(1001, "can't get floatLayer");
            }
            kb3.f(floatLayer, context, optString, optBoolean);
            c92.i("LoadingViewApi", "show loading success");
            return c42.f();
        }
        return (c42) invokeL.objValue;
    }
}
