package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.wp0;
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
public class zp0 extends yj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reward" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements wp0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad1 a;

        public a(zp0 zp0Var, ad1 ad1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp0Var, ad1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad1Var;
        }
    }

    public zp0() {
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

    @Override // com.baidu.tieba.yj0
    public boolean b(@NonNull Context context, @NonNull ck0 ck0Var, @Nullable Map<String, Object> map, @Nullable gk0 gk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ck0Var, map, gk0Var)) == null) {
            super.b(context, ck0Var, map, gk0Var);
            String str = ck0Var.d().get("task_params");
            if (TextUtils.isEmpty(str)) {
                c(gk0Var, ck0Var, 202, false);
                return true;
            }
            HashMap<String, String> e = e(str);
            if (e != null && !e.isEmpty()) {
                if (TextUtils.isEmpty(e.get("android_pid")) && io0.b().a().a("reward_sdk_switch", 0) != 1) {
                    c(gk0Var, ck0Var, 202, false);
                    return true;
                }
                String str2 = e.get("android_pid");
                e.remove("android_pid");
                e.remove("ios_pid");
                ad1 ad1Var = new ad1(context);
                ad1Var.e(context.getString(R.string.nad_reward_video_lp_task_loading));
                ad1Var.c(false);
                ad1Var.d(false);
                y51.b(ad1Var);
                bq0 bq0Var = new bq0(e);
                wp0 wp0Var = (wp0) ServiceManager.getService(wp0.a);
                if (wp0Var != null && io0.b().a().a("reward_sdk_switch", 0) == 1) {
                    wp0Var.a(f(str), new a(this, ad1Var));
                    return true;
                }
                bq0Var.e(ad1Var, str2);
                c(gk0Var, ck0Var, 0, true);
                return true;
            }
            c(gk0Var, ck0Var, 202, false);
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
        is0 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("ext_policy");
                if (TextUtils.isEmpty(optString)) {
                    a2 = is0.e();
                } else {
                    a2 = is0.a(new JSONObject(optString));
                }
                if (a2 != null) {
                    a2.c = "1";
                    jSONObject.putOpt("ext_policy", is0.f(a2).toString());
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
