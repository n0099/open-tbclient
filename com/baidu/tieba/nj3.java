package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.fm3;
import com.baidu.tieba.q23;
import com.baidu.tieba.qk3;
import com.baidu.tieba.uk3;
import com.baidu.tieba.yj3;
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
/* loaded from: classes5.dex */
public final class nj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj1 a;

        public a(yj1 yj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
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

    /* loaded from: classes5.dex */
    public final class b extends sz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk3.c c;

        @Override // com.baidu.tieba.sz2, com.baidu.tieba.rz2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public b(uk3.c cVar) {
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
        @Override // com.baidu.tieba.sz2, com.baidu.tieba.tz2, com.baidu.tieba.rz2
        public void onEvent(pz2 pz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pz2Var) == null) {
                if (nj3.a) {
                    Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
                }
                String str = null;
                if (pz2Var.a() != null) {
                    str = ((Bundle) pz2Var.a()).getString(TiebaStatic.LogFields.RESULT);
                } else if (nj3.a) {
                    Log.d("AccountUtils", "get openBduss : result null");
                }
                this.c.a(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c extends sz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 c;

        @Override // com.baidu.tieba.sz2, com.baidu.tieba.rz2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public c(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sz2, com.baidu.tieba.tz2, com.baidu.tieba.rz2
        public void onEvent(pz2 pz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pz2Var) == null) {
                if (nj3.a) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle = null;
                if (pz2Var.a() != null) {
                    if (nj3.a) {
                        Log.d("AccountUtils", "get stoken : result " + pz2Var.a());
                    }
                    bundle = ((Bundle) pz2Var.a()).getBundle("key_result_stokent");
                } else if (nj3.a) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                this.c.a(bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class d implements yj3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;

        @Override // com.baidu.tieba.yj3.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.yj3.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public d(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
        }

        @Override // com.baidu.tieba.yj3.a
        public void a(yj3 yj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yj3Var) == null) {
                this.a.a(null);
            }
        }

        @Override // com.baidu.tieba.yj3.a
        public void b(yj3 yj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yj3Var) == null) {
                if (yj3Var.a != 0 || yj3Var.b == null) {
                    this.a.a(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry entry : yj3Var.b.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString(str, (String) entry.getValue());
                    }
                }
                this.a.a(bundle);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class e implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck1 a;

        public e(ck1 ck1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (wj1.a) {
                        Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                    }
                    this.a.a(0);
                    return;
                }
                if (wj1.a) {
                    Log.i("AccountUtils", string);
                }
                this.a.b(mg3.d(string));
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class f implements ok3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ fi3 b;

        public f(Bundle bundle, fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, fi3Var};
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
            this.b = fi3Var;
        }

        @Override // com.baidu.tieba.ok3
        public void a(mk3 mk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mk3Var) == null) {
                if (nj3.a) {
                    Log.d("AccountUtils", "callbackkey=" + mk3Var.a);
                }
                this.a.putString("callbackKey", mk3Var.a);
                fi3 fi3Var = this.b;
                if (fi3Var != null) {
                    fi3Var.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.ok3
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (nj3.a) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                this.a.putString("failMsg", str);
                fi3 fi3Var = this.b;
                if (fi3Var != null) {
                    fi3Var.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class g implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;

        public g(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                fi3 fi3Var = this.a;
                if (fi3Var != null) {
                    fi3Var.a(lg3.d(bundle, TiebaStatic.LogFields.RESULT));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class h implements Runnable {
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
            nj3.O(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public final class i implements DialogInterface.OnClickListener {
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
                nj3.M(this.a, true, null, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948004338, "Lcom/baidu/tieba/nj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948004338, "Lcom/baidu/tieba/nj3;");
                return;
            }
        }
        a = wj1.a;
    }

    public static nk3 A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return null;
            }
            return ik3.a().d(context);
        }
        return (nk3) invokeL.objValue;
    }

    public static ok3 C(fi3 fi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fi3Var)) == null) {
            return new f(new Bundle(), fi3Var);
        }
        return (ok3) invokeL.objValue;
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return false;
            }
            return ik3.a().g(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, wj3.class, null);
            if (!callOnMainWithContentProvider.isOk() || !callOnMainWithContentProvider.mResult.getBoolean(TiebaStatic.LogFields.RESULT, false)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(ak1 ak1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, ak1Var) != null) || ak1Var == null) {
            return;
        }
        ik3.a().h(ak1Var);
    }

    public static nk3 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return A(context);
            }
            return B(context);
        }
        return (nk3) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            String bduss = ik3.a().getBduss(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, pj3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString(TiebaStatic.LogFields.RESULT, "");
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
            return ik3.a().k(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, qj3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString(TiebaStatic.LogFields.RESULT, "");
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
            return ik3.a().a(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, sj3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString(TiebaStatic.LogFields.RESULT, "");
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
            return ik3.a().b(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, uj3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString(TiebaStatic.LogFields.RESULT, "");
        }
        return (String) invokeL.objValue;
    }

    public static nk3 B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, vj3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return null;
            }
            nk3 nk3Var = new nk3();
            nk3Var.a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            nk3Var.b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return nk3Var;
        }
        return (nk3) invokeL.objValue;
    }

    public static void D(Activity activity, JSONObject jSONObject) {
        JSONObject c2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, jSONObject) == null) && (c2 = k83.c(jSONObject)) != null && activity != null) {
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
                    gh3.e0(new h(activity, str, optString));
                }
            }
        }
    }

    public static void H(Activity activity, String str, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, str, fi3Var) == null) {
            ik3.a().l(activity, "baidu_mini_programs_" + str, i(activity), C(fi3Var));
        }
    }

    public static void K(Activity activity, String str, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, activity, str, fi3Var) == null) {
            ik3.a().e(activity, "baidu_mini_programs_" + str, i(activity), C(fi3Var));
        }
    }

    public static void L(Context context, Bundle bundle, yj1 yj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, yj1Var) == null) {
            if (!ProcessUtils.isMainProcess()) {
                yj1Var.onResult(-1);
            } else {
                ik3.a().c(context, bundle, yj1Var);
            }
        }
    }

    public static void P(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, gVar, str) == null) {
            ik3.a().j(context, gVar, str);
        }
    }

    public static void n(String str, ArrayList arrayList, uk3.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65566, null, str, arrayList, cVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        ik3.a().n(str, arrayList, cVar);
    }

    public static void t(Context context, fi3 fi3Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, null, context, fi3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                u(context, fi3Var, strArr);
            } else {
                w(fi3Var, strArr);
            }
        }
    }

    public static void v(yj3.a aVar, String str, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, aVar, str, list) == null) {
            ik3.a().o(aVar, str, list);
        }
    }

    public static void I(Activity activity, boolean z, String str, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, Boolean.valueOf(z), str, fi3Var}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRealName", z);
            bundle.putString("swanAppId", str);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, oj3.class, bundle, new g(fi3Var));
        }
    }

    public static void M(Activity activity, boolean z, Bundle bundle, yj1 yj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, Boolean.valueOf(z), bundle, yj1Var}) == null) {
            if (ProcessUtils.isMainProcess()) {
                L(activity, bundle, yj1Var);
            } else {
                N(activity, z, bundle, yj1Var);
            }
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, yj1 yj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), bundle, yj1Var}) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_login_force", z);
            bundle2.putBundle("key_login_params", bundle);
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, xj3.class, bundle2, new a(yj1Var));
        }
    }

    public static void p(Context context, String str, ArrayList arrayList, uk3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, str, arrayList, cVar) == null) {
            m33 M = m33.M();
            if (M == null) {
                cVar.a(null);
                return;
            }
            h03 y = M.y();
            if (y == null) {
                cVar.a(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_result_client_id", str);
            bundle.putStringArrayList("key_param_tpl_list", arrayList);
            y.X(bundle, rj3.class, new b(cVar));
        }
    }

    public static void J(Activity activity, String str, String str2, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, activity, str, str2, fi3Var) == null) {
            boolean equals = TextUtils.equals(str, "1");
            if (ProcessUtils.isMainProcess()) {
                if (equals) {
                    H(activity, str2, fi3Var);
                    return;
                } else {
                    K(activity, str2, fi3Var);
                    return;
                }
            }
            I(activity, equals, str2, fi3Var);
        }
    }

    public static void o(Context context, String str, ArrayList arrayList, uk3.c cVar) {
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
            q23.a aVar = new q23.a(activity);
            aVar.V(str);
            aVar.x(str2);
            aVar.n(new ui3());
            aVar.m(true);
            aVar.P(activity.getString(R.string.obfuscated_res_0x7f0f127c), new i(activity));
            aVar.C(activity.getString(R.string.obfuscated_res_0x7f0f127d), null);
            aVar.X();
        }
    }

    public static void u(Context context, fi3 fi3Var, String... strArr) {
        List asList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, fi3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                String h2 = h(context);
                if (TextUtils.isEmpty(h2)) {
                    fi3Var.a(null);
                    return;
                }
                d dVar = new d(fi3Var);
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

    public static void d(Context context, qk3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65556, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        ik3.a().i(context, dVar);
    }

    public static void e(Activity activity, ck1 ck1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, activity, ck1Var) == null) {
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, qk3.class, new e(ck1Var));
        }
    }

    public static void f(Context context, fm3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65558, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        ik3.a().f(context, dVar);
    }

    public static void w(fi3 fi3Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, fi3Var, strArr) == null) {
            if (strArr != null && strArr.length >= 1) {
                m33 M = m33.M();
                if (M == null) {
                    fi3Var.a(null);
                    return;
                }
                h03 y = M.y();
                if (y == null) {
                    fi3Var.a(null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("key_param_tpl_list", strArr);
                y.X(bundle, tj3.class, new c(fi3Var));
                return;
            }
            fi3Var.a(null);
        }
    }
}
