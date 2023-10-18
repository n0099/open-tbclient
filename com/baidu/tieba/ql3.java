package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.bm3;
import com.baidu.tieba.io3;
import com.baidu.tieba.t43;
import com.baidu.tieba.tm3;
import com.baidu.tieba.xm3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ql3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public a(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, delegateResult) != null) || this.a == null) {
                return;
            }
            if (!delegateResult.isOk()) {
                this.a.onResult(-1);
                return;
            }
            this.a.onResult(delegateResult.mResult.getInt("result_code", -1));
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends v13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm3.c c;

        @Override // com.baidu.tieba.v13, com.baidu.tieba.u13
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public b(xm3.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v13, com.baidu.tieba.w13, com.baidu.tieba.u13
        public void onEvent(@NonNull s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s13Var) == null) {
                if (ql3.a) {
                    Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
                }
                String str = null;
                if (s13Var.a() != null) {
                    str = s13Var.a().getString("result");
                } else if (ql3.a) {
                    Log.d("AccountUtils", "get openBduss : result null");
                }
                this.c.a(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends v13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 c;

        @Override // com.baidu.tieba.v13, com.baidu.tieba.u13
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public c(ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ik3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v13, com.baidu.tieba.w13, com.baidu.tieba.u13
        public void onEvent(@NonNull s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s13Var) == null) {
                if (ql3.a) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle = null;
                if (s13Var.a() != null) {
                    if (ql3.a) {
                        Log.d("AccountUtils", "get stoken : result " + s13Var.a());
                    }
                    bundle = s13Var.a().getBundle("key_result_stokent");
                } else if (ql3.a) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                this.c.a(bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements bm3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;

        @Override // com.baidu.tieba.bm3.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.bm3.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public d(ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
        }

        @Override // com.baidu.tieba.bm3.a
        public void a(bm3 bm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bm3Var) == null) {
                this.a.a(null);
            }
        }

        @Override // com.baidu.tieba.bm3.a
        public void b(bm3 bm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bm3Var) == null) {
                if (bm3Var.a != 0 || bm3Var.b == null) {
                    this.a.a(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : bm3Var.b.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                this.a.a(bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm1 a;

        public e(gm1 gm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gm1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (am1.a) {
                        Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                    }
                    this.a.a(0);
                    return;
                }
                if (am1.a) {
                    Log.i("AccountUtils", string);
                }
                this.a.b(pi3.d(string));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements rm3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ ik3 b;

        public f(Bundle bundle, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
            this.b = ik3Var;
        }

        @Override // com.baidu.tieba.rm3
        public void a(pm3 pm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pm3Var) == null) {
                if (ql3.a) {
                    Log.d("AccountUtils", "callbackkey=" + pm3Var.a);
                }
                this.a.putString("callbackKey", pm3Var.a);
                ik3 ik3Var = this.b;
                if (ik3Var != null) {
                    ik3Var.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.rm3
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (ql3.a) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                this.a.putString("failMsg", str);
                ik3 ik3Var = this.b;
                if (ik3Var != null) {
                    ik3Var.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;

        public g(ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                ik3 ik3Var = this.a;
                if (ik3Var != null) {
                    ik3Var.a(oi3.d(bundle, "result"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public h(Activity activity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ql3.O(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public i(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ql3.M(this.a, true, null, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095633, "Lcom/baidu/tieba/ql3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095633, "Lcom/baidu/tieba/ql3;");
                return;
            }
        }
        a = am1.a;
    }

    public static qm3 A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return null;
            }
            return lm3.a().d(context);
        }
        return (qm3) invokeL.objValue;
    }

    public static rm3 C(ik3<Bundle> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ik3Var)) == null) {
            return new f(new Bundle(), ik3Var);
        }
        return (rm3) invokeL.objValue;
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return false;
            }
            return lm3.a().g(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return E(context);
            }
            return G(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, zl3.class, null);
            if (!callOnMainWithContentProvider.isOk() || !callOnMainWithContentProvider.mResult.getBoolean("result", false)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(em1 em1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, em1Var) != null) || em1Var == null) {
            return;
        }
        lm3.a().h(em1Var);
    }

    public static qm3 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return A(context);
            }
            return B(context);
        }
        return (qm3) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            String bduss = lm3.a().getBduss(context);
            if (TextUtils.isEmpty(bduss)) {
                return "";
            }
            return bduss;
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return h(context);
            }
            return j(context);
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, sl3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            return lm3.a().k(context);
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return k(context);
            }
            return m(context);
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, tl3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            return lm3.a().a(context);
        }
        return (String) invokeL.objValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return q(context);
            }
            return s(context);
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, vl3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            return lm3.a().b(context);
        }
        return (String) invokeL.objValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return x(context);
            }
            return z(context);
        }
        return (String) invokeL.objValue;
    }

    public static String z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, xl3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static qm3 B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, yl3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return null;
            }
            qm3 qm3Var = new qm3();
            qm3Var.a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            qm3Var.b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return qm3Var;
        }
        return (qm3) invokeL.objValue;
    }

    public static void D(Activity activity, JSONObject jSONObject) {
        JSONObject c2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, jSONObject) == null) && (c2 = na3.c(jSONObject)) != null && activity != null) {
            int optInt = c2.optInt("errno", 10001);
            String optString = c2.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = c2.optJSONObject("tipoption");
                if (optJSONObject != null) {
                    str = optJSONObject.optString("title");
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString)) {
                    jj3.e0(new h(activity, str, optString));
                }
            }
        }
    }

    public static void H(Activity activity, String str, ik3<Bundle> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, str, ik3Var) == null) {
            lm3.a().l(activity, "baidu_mini_programs_" + str, i(activity), C(ik3Var));
        }
    }

    public static void K(Activity activity, String str, ik3<Bundle> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, activity, str, ik3Var) == null) {
            lm3.a().e(activity, "baidu_mini_programs_" + str, i(activity), C(ik3Var));
        }
    }

    public static void L(Context context, Bundle bundle, cm1 cm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, cm1Var) == null) {
            if (!ProcessUtils.isMainProcess()) {
                cm1Var.onResult(-1);
            } else {
                lm3.a().c(context, bundle, cm1Var);
            }
        }
    }

    public static void P(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, gVar, str) == null) {
            lm3.a().j(context, gVar, str);
        }
    }

    public static void n(String str, ArrayList<String> arrayList, xm3.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65566, null, str, arrayList, cVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        lm3.a().n(str, arrayList, cVar);
    }

    public static void t(Context context, ik3<Bundle> ik3Var, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, null, context, ik3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                u(context, ik3Var, strArr);
            } else {
                w(ik3Var, strArr);
            }
        }
    }

    public static void v(bm3.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, aVar, str, list) == null) {
            lm3.a().o(aVar, str, list);
        }
    }

    public static void I(Activity activity, boolean z, String str, ik3<Bundle> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, Boolean.valueOf(z), str, ik3Var}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRealName", z);
            bundle.putString("swanAppId", str);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, rl3.class, bundle, new g(ik3Var));
        }
    }

    public static void M(Activity activity, boolean z, Bundle bundle, cm1 cm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, Boolean.valueOf(z), bundle, cm1Var}) == null) {
            if (ProcessUtils.isMainProcess()) {
                L(activity, bundle, cm1Var);
            } else {
                N(activity, z, bundle, cm1Var);
            }
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, cm1 cm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), bundle, cm1Var}) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_login_force", z);
            bundle2.putBundle("key_login_params", bundle);
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, am3.class, bundle2, new a(cm1Var));
        }
    }

    public static void p(Context context, String str, ArrayList<String> arrayList, xm3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, str, arrayList, cVar) == null) {
            p53 M = p53.M();
            if (M == null) {
                cVar.a(null);
                return;
            }
            k23 y = M.y();
            if (y == null) {
                cVar.a(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_result_client_id", str);
            bundle.putStringArrayList("key_param_tpl_list", arrayList);
            y.X(bundle, ul3.class, new b(cVar));
        }
    }

    public static void J(Activity activity, String str, String str2, ik3<Bundle> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, activity, str, str2, ik3Var) == null) {
            boolean equals = TextUtils.equals(str, "1");
            if (ProcessUtils.isMainProcess()) {
                if (equals) {
                    H(activity, str2, ik3Var);
                    return;
                } else {
                    K(activity, str2, ik3Var);
                    return;
                }
            }
            I(activity, equals, str2, ik3Var);
        }
    }

    public static void o(Context context, String str, ArrayList<String> arrayList, xm3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65567, null, context, str, arrayList, cVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                n(str, arrayList, cVar);
            } else {
                p(context, str, arrayList, cVar);
            }
        }
    }

    public static void O(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, activity, str, str2) == null) {
            t43.a aVar = new t43.a(activity);
            aVar.V(str);
            aVar.x(str2);
            aVar.n(new xk3());
            aVar.m(true);
            aVar.P(activity.getString(R.string.obfuscated_res_0x7f0f14e9), new i(activity));
            aVar.C(activity.getString(R.string.obfuscated_res_0x7f0f14ea), null);
            aVar.X();
        }
    }

    public static void u(Context context, ik3<Bundle> ik3Var, @Nullable String... strArr) {
        List asList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, ik3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                String h2 = h(context);
                if (TextUtils.isEmpty(h2)) {
                    ik3Var.a(null);
                    return;
                }
                d dVar = new d(ik3Var);
                if (strArr == null) {
                    asList = Collections.emptyList();
                } else {
                    asList = Arrays.asList(strArr);
                }
                v(dVar, h2, asList);
                return;
            }
            throw new IllegalStateException("must call in MainProcess");
        }
    }

    public static void d(Context context, tm3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65556, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        lm3.a().i(context, dVar);
    }

    public static void e(Activity activity, gm1 gm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, activity, gm1Var) == null) {
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, tm3.class, new e(gm1Var));
        }
    }

    public static void f(Context context, io3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65558, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        lm3.a().f(context, dVar);
    }

    public static void w(ik3<Bundle> ik3Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, ik3Var, strArr) == null) {
            if (strArr != null && strArr.length >= 1) {
                p53 M = p53.M();
                if (M == null) {
                    ik3Var.a(null);
                    return;
                }
                k23 y = M.y();
                if (y == null) {
                    ik3Var.a(null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("key_param_tpl_list", strArr);
                y.X(bundle, wl3.class, new c(ik3Var));
                return;
            }
            ik3Var.a(null);
        }
    }
}
