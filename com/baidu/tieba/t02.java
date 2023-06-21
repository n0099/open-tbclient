package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.gb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t02 extends s02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t02(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public z32 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new z32(1001, "context not support");
            }
            ib2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new z32(1001, "none fragmentManger");
            }
            fb2 m = Y.m();
            if (!(m instanceof gb3.a)) {
                return new z32(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new z32(1001, "fragment has detached");
            }
            hb3.c(m);
            z82.i("LoadingViewApi", "hide loading success");
            return z32.f();
        }
        return (z32) invokeV.objValue;
    }

    public z32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                z82.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new z32(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            z82.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new z32(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new z32(1001, "context not support");
            }
            ib2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new z32(1001, "none fragment");
            }
            fb2 m = Y.m();
            if (!(m instanceof gb3.a)) {
                return new z32(1001, "fragment not support");
            }
            gb3 floatLayer = ((gb3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new z32(1001, "can't get floatLayer");
            }
            hb3.f(floatLayer, context, optString, optBoolean);
            z82.i("LoadingViewApi", "show loading success");
            return z32.f();
        }
        return (z32) invokeL.objValue;
    }
}
