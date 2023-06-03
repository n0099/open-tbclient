package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.fb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s02 extends r02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s02(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public y32 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new y32(1001, "context not support");
            }
            hb2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new y32(1001, "none fragmentManger");
            }
            eb2 m = Y.m();
            if (!(m instanceof fb3.a)) {
                return new y32(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new y32(1001, "fragment has detached");
            }
            gb3.c(m);
            y82.i("LoadingViewApi", "hide loading success");
            return y32.f();
        }
        return (y32) invokeV.objValue;
    }

    public y32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                y82.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new y32(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<y32, JSONObject> s = s(str);
            y32 y32Var = (y32) s.first;
            if (!y32Var.isSuccess()) {
                return y32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            y82.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new y32(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new y32(1001, "context not support");
            }
            hb2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new y32(1001, "none fragment");
            }
            eb2 m = Y.m();
            if (!(m instanceof fb3.a)) {
                return new y32(1001, "fragment not support");
            }
            fb3 floatLayer = ((fb3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new y32(1001, "can't get floatLayer");
            }
            gb3.f(floatLayer, context, optString, optBoolean);
            y82.i("LoadingViewApi", "show loading success");
            return y32.f();
        }
        return (y32) invokeL.objValue;
    }
}
