package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.hq0;
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
/* loaded from: classes6.dex */
public class kq0 extends bk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bk0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reward" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements hq0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc1 a;

        public a(kq0 kq0Var, sc1 sc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq0Var, sc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sc1Var;
        }
    }

    public kq0() {
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

    @Override // com.baidu.tieba.bk0
    public boolean b(@NonNull Context context, @NonNull fk0 fk0Var, @Nullable Map<String, Object> map, @Nullable jk0 jk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fk0Var, map, jk0Var)) == null) {
            super.b(context, fk0Var, map, jk0Var);
            String str = fk0Var.d().get("task_params");
            if (TextUtils.isEmpty(str)) {
                c(jk0Var, fk0Var, 202, false);
                return true;
            }
            HashMap<String, String> e = e(str);
            if (e != null && !e.isEmpty()) {
                if (TextUtils.isEmpty(e.get("android_pid")) && so0.b().a().a("reward_sdk_switch", 0) != 1) {
                    c(jk0Var, fk0Var, 202, false);
                    return true;
                }
                String str2 = e.get("android_pid");
                e.remove("android_pid");
                e.remove("ios_pid");
                sc1 sc1Var = new sc1(context);
                sc1Var.e(context.getString(R.string.nad_reward_video_lp_task_loading));
                sc1Var.c(false);
                sc1Var.d(false);
                w61.b(sc1Var);
                mq0 mq0Var = new mq0(e);
                hq0 hq0Var = (hq0) ServiceManager.getService(hq0.a);
                if (hq0Var != null && so0.b().a().a("reward_sdk_switch", 0) == 1) {
                    hq0Var.a(f(str), new a(this, sc1Var));
                    return true;
                }
                mq0Var.e(sc1Var, str2);
                c(jk0Var, fk0Var, 0, true);
                return true;
            }
            c(jk0Var, fk0Var, 202, false);
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
        ts0 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("ext_policy");
                if (TextUtils.isEmpty(optString)) {
                    a2 = ts0.e();
                } else {
                    a2 = ts0.a(new JSONObject(optString));
                }
                if (a2 != null) {
                    a2.c = "1";
                    jSONObject.putOpt("ext_policy", ts0.f(a2).toString());
                    jSONObject.putOpt(AdExtParam.KEY_NAD_CORE_VERSION, "5.12.0.75");
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
