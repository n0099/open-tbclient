package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ka3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xz1 extends wz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz1(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d32 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new d32(1001, "context not support");
            }
            ma2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new d32(1001, "none fragmentManger");
            }
            ja2 m = Y.m();
            if (!(m instanceof ka3.a)) {
                return new d32(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new d32(1001, "fragment has detached");
            }
            la3.c(m);
            d82.i("LoadingViewApi", "hide loading success");
            return d32.f();
        }
        return (d32) invokeV.objValue;
    }

    public d32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                d82.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new d32(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            d82.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new d32(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new d32(1001, "context not support");
            }
            ma2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new d32(1001, "none fragment");
            }
            ja2 m = Y.m();
            if (!(m instanceof ka3.a)) {
                return new d32(1001, "fragment not support");
            }
            ka3 floatLayer = ((ka3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new d32(1001, "can't get floatLayer");
            }
            la3.f(floatLayer, context, optString, optBoolean);
            d82.i("LoadingViewApi", "show loading success");
            return d32.f();
        }
        return (d32) invokeL.objValue;
    }
}
