package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.tp0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes8.dex */
public class wp0 extends vj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reward" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements tp0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc1 a;

        public a(wp0 wp0Var, xc1 xc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp0Var, xc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc1Var;
        }
    }

    public wp0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.vj0
    public boolean b(@NonNull Context context, @NonNull zj0 zj0Var, @Nullable Map<String, Object> map, @Nullable dk0 dk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zj0Var, map, dk0Var)) == null) {
            super.b(context, zj0Var, map, dk0Var);
            String str = zj0Var.d().get("task_params");
            if (TextUtils.isEmpty(str)) {
                c(dk0Var, zj0Var, 202, false);
                return true;
            }
            HashMap<String, String> e = e(str);
            if (e != null && !e.isEmpty()) {
                if (TextUtils.isEmpty(e.get("android_pid")) && fo0.b().a().a("reward_sdk_switch", 0) != 1) {
                    c(dk0Var, zj0Var, 202, false);
                    return true;
                }
                String str2 = e.get("android_pid");
                e.remove("android_pid");
                e.remove("ios_pid");
                xc1 xc1Var = new xc1(context);
                xc1Var.e(context.getString(R.string.nad_reward_video_lp_task_loading));
                xc1Var.c(false);
                xc1Var.d(false);
                v51.b(xc1Var);
                yp0 yp0Var = new yp0(e);
                tp0 tp0Var = (tp0) ServiceManager.getService(tp0.a);
                if (tp0Var != null && fo0.b().a().a("reward_sdk_switch", 0) == 1) {
                    tp0Var.a(f(str), new a(this, xc1Var));
                    return true;
                }
                yp0Var.e(xc1Var, str2);
                c(dk0Var, zj0Var, 0, true);
                return true;
            }
            c(dk0Var, zj0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final HashMap<String, String> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                HashMap<String, String> hashMap = new HashMap<>();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (HashMap) invokeL.objValue;
    }

    @Nullable
    public final JSONObject f(@Nullable String str) {
        InterceptResult invokeL;
        fs0 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("ext_policy");
                if (TextUtils.isEmpty(optString)) {
                    a2 = fs0.e();
                } else {
                    a2 = fs0.a(new JSONObject(optString));
                }
                if (a2 != null) {
                    a2.c = "1";
                    jSONObject.putOpt("ext_policy", fs0.f(a2).toString());
                    jSONObject.putOpt(AdExtParam.KEY_NAD_CORE_VERSION, "5.11.0.5");
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
