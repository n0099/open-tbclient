package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p02 extends o02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p02(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public v32 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new v32(1001, "context not support");
            }
            eb2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new v32(1001, "none fragmentManger");
            }
            bb2 m = Y.m();
            if (!(m instanceof cb3.a)) {
                return new v32(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new v32(1001, "fragment has detached");
            }
            db3.c(m);
            v82.i("LoadingViewApi", "hide loading success");
            return v32.f();
        }
        return (v32) invokeV.objValue;
    }

    public v32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                v82.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new v32(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            v82.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                return new v32(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new v32(1001, "context not support");
            }
            eb2 Y = ((SwanAppActivity) context).Y();
            if (Y == null) {
                return new v32(1001, "none fragment");
            }
            bb2 m = Y.m();
            if (!(m instanceof cb3.a)) {
                return new v32(1001, "fragment not support");
            }
            cb3 floatLayer = ((cb3.a) m).getFloatLayer();
            if (floatLayer == null) {
                return new v32(1001, "can't get floatLayer");
            }
            db3.f(floatLayer, context, optString, optBoolean);
            v82.i("LoadingViewApi", "show loading success");
            return v32.f();
        }
        return (v32) invokeL.objValue;
    }
}
