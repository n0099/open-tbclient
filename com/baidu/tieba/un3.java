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
import com.baidu.tieba.bp3;
import com.baidu.tieba.fo3;
import com.baidu.tieba.mq3;
import com.baidu.tieba.x63;
import com.baidu.tieba.xo3;
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
/* loaded from: classes6.dex */
public final class un3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo1 a;

        public a(fo1 fo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo1Var;
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

    /* loaded from: classes6.dex */
    public static class b extends z33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp3.c c;

        @Override // com.baidu.tieba.z33, com.baidu.tieba.y33
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public b(bp3.c cVar) {
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
        @Override // com.baidu.tieba.z33, com.baidu.tieba.a43, com.baidu.tieba.y33
        public void onEvent(@NonNull w33 w33Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w33Var) == null) {
                if (un3.a) {
                    Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
                }
                String str = null;
                if (w33Var.a() != null) {
                    str = w33Var.a().getString("result");
                } else if (un3.a) {
                    Log.d("AccountUtils", "get openBduss : result null");
                }
                this.c.a(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends z33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 c;

        @Override // com.baidu.tieba.z33, com.baidu.tieba.y33
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        public c(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z33, com.baidu.tieba.a43, com.baidu.tieba.y33
        public void onEvent(@NonNull w33 w33Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w33Var) == null) {
                if (un3.a) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle = null;
                if (w33Var.a() != null) {
                    if (un3.a) {
                        Log.d("AccountUtils", "get stoken : result " + w33Var.a());
                    }
                    bundle = w33Var.a().getBundle("key_result_stokent");
                } else if (un3.a) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                this.c.a(bundle);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements fo3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        @Override // com.baidu.tieba.fo3.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fo3.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public d(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
        }

        @Override // com.baidu.tieba.fo3.a
        public void a(fo3 fo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fo3Var) == null) {
                this.a.a(null);
            }
        }

        @Override // com.baidu.tieba.fo3.a
        public void b(fo3 fo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fo3Var) == null) {
                if (fo3Var.a != 0 || fo3Var.b == null) {
                    this.a.a(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : fo3Var.b.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                this.a.a(bundle);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo1 a;

        public e(jo1 jo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (do1.a) {
                        Log.e("AccountUtils", delegateResult.mResult.getString("errorMsg"));
                    }
                    this.a.a(0);
                    return;
                }
                if (do1.a) {
                    Log.i("AccountUtils", string);
                }
                this.a.b(tk3.d(string));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements vo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ mm3 b;

        public f(Bundle bundle, mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, mm3Var};
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
            this.b = mm3Var;
        }

        @Override // com.baidu.tieba.vo3
        public void a(to3 to3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, to3Var) == null) {
                if (un3.a) {
                    Log.d("AccountUtils", "callbackkey=" + to3Var.a);
                }
                this.a.putString("callbackKey", to3Var.a);
                mm3 mm3Var = this.b;
                if (mm3Var != null) {
                    mm3Var.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.vo3
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (un3.a) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                this.a.putString("failMsg", str);
                mm3 mm3Var = this.b;
                if (mm3Var != null) {
                    mm3Var.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        public g(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                mm3 mm3Var = this.a;
                if (mm3Var != null) {
                    mm3Var.a(sk3.d(bundle, "result"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            un3.O(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
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
                un3.M(this.a, true, null, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216719, "Lcom/baidu/tieba/un3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216719, "Lcom/baidu/tieba/un3;");
                return;
            }
        }
        a = do1.a;
    }

    public static uo3 A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return null;
            }
            return po3.a().d(context);
        }
        return (uo3) invokeL.objValue;
    }

    public static vo3 C(mm3<Bundle> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mm3Var)) == null) {
            return new f(new Bundle(), mm3Var);
        }
        return (vo3) invokeL.objValue;
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return false;
            }
            return po3.a().g(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, do3.class, null);
            if (!callOnMainWithContentProvider.isOk() || !callOnMainWithContentProvider.mResult.getBoolean("result", false)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(ho1 ho1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, ho1Var) != null) || ho1Var == null) {
            return;
        }
        po3.a().h(ho1Var);
    }

    public static uo3 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return A(context);
            }
            return B(context);
        }
        return (uo3) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return "";
            }
            String bduss = po3.a().getBduss(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, wn3.class, null);
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
            return po3.a().k(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, xn3.class, null);
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
            return po3.a().a(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, zn3.class, null);
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
            return po3.a().b(context);
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
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, bo3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return "";
            }
            return callOnMainWithContentProvider.mResult.getString("result", "");
        }
        return (String) invokeL.objValue;
    }

    public static uo3 B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, co3.class, null);
            if (!callOnMainWithContentProvider.isOk()) {
                return null;
            }
            uo3 uo3Var = new uo3();
            uo3Var.a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            uo3Var.b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return uo3Var;
        }
        return (uo3) invokeL.objValue;
    }

    public static void D(Activity activity, JSONObject jSONObject) {
        JSONObject c2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, jSONObject) == null) && (c2 = rc3.c(jSONObject)) != null && activity != null) {
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
                    nl3.e0(new h(activity, str, optString));
                }
            }
        }
    }

    public static void H(Activity activity, String str, mm3<Bundle> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, str, mm3Var) == null) {
            po3.a().l(activity, "baidu_mini_programs_" + str, i(activity), C(mm3Var));
        }
    }

    public static void K(Activity activity, String str, mm3<Bundle> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, activity, str, mm3Var) == null) {
            po3.a().e(activity, "baidu_mini_programs_" + str, i(activity), C(mm3Var));
        }
    }

    public static void L(Context context, Bundle bundle, fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, fo1Var) == null) {
            if (!ProcessUtils.isMainProcess()) {
                fo1Var.onResult(-1);
            } else {
                po3.a().c(context, bundle, fo1Var);
            }
        }
    }

    public static void P(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, gVar, str) == null) {
            po3.a().j(context, gVar, str);
        }
    }

    public static void n(String str, ArrayList<String> arrayList, bp3.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65566, null, str, arrayList, cVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        po3.a().n(str, arrayList, cVar);
    }

    public static void t(Context context, mm3<Bundle> mm3Var, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, null, context, mm3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                u(context, mm3Var, strArr);
            } else {
                w(mm3Var, strArr);
            }
        }
    }

    public static void v(fo3.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, aVar, str, list) == null) {
            po3.a().o(aVar, str, list);
        }
    }

    public static void I(Activity activity, boolean z, String str, mm3<Bundle> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, Boolean.valueOf(z), str, mm3Var}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRealName", z);
            bundle.putString("swanAppId", str);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, vn3.class, bundle, new g(mm3Var));
        }
    }

    public static void M(Activity activity, boolean z, Bundle bundle, fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, Boolean.valueOf(z), bundle, fo1Var}) == null) {
            if (ProcessUtils.isMainProcess()) {
                L(activity, bundle, fo1Var);
            } else {
                N(activity, z, bundle, fo1Var);
            }
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), bundle, fo1Var}) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_login_force", z);
            bundle2.putBundle("key_login_params", bundle);
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, eo3.class, bundle2, new a(fo1Var));
        }
    }

    public static void p(Context context, String str, ArrayList<String> arrayList, bp3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, str, arrayList, cVar) == null) {
            t73 M = t73.M();
            if (M == null) {
                cVar.a(null);
                return;
            }
            o43 y = M.y();
            if (y == null) {
                cVar.a(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_result_client_id", str);
            bundle.putStringArrayList("key_param_tpl_list", arrayList);
            y.X(bundle, yn3.class, new b(cVar));
        }
    }

    public static void J(Activity activity, String str, String str2, mm3<Bundle> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, activity, str, str2, mm3Var) == null) {
            boolean equals = TextUtils.equals(str, "1");
            if (ProcessUtils.isMainProcess()) {
                if (equals) {
                    H(activity, str2, mm3Var);
                    return;
                } else {
                    K(activity, str2, mm3Var);
                    return;
                }
            }
            I(activity, equals, str2, mm3Var);
        }
    }

    public static void o(Context context, String str, ArrayList<String> arrayList, bp3.c cVar) {
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
            x63.a aVar = new x63.a(activity);
            aVar.V(str);
            aVar.x(str2);
            aVar.n(new bn3());
            aVar.m(true);
            aVar.P(activity.getString(R.string.obfuscated_res_0x7f0f133f), new i(activity));
            aVar.C(activity.getString(R.string.obfuscated_res_0x7f0f1340), null);
            aVar.X();
        }
    }

    public static void u(Context context, mm3<Bundle> mm3Var, @Nullable String... strArr) {
        List asList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, mm3Var, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                String h2 = h(context);
                if (TextUtils.isEmpty(h2)) {
                    mm3Var.a(null);
                    return;
                }
                d dVar = new d(mm3Var);
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

    public static void d(Context context, xo3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65556, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        po3.a().i(context, dVar);
    }

    public static void e(Activity activity, jo1 jo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, activity, jo1Var) == null) {
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, xo3.class, new e(jo1Var));
        }
    }

    public static void f(Context context, mq3.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65558, null, context, dVar) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        po3.a().f(context, dVar);
    }

    public static void w(mm3<Bundle> mm3Var, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, mm3Var, strArr) == null) {
            if (strArr != null && strArr.length >= 1) {
                t73 M = t73.M();
                if (M == null) {
                    mm3Var.a(null);
                    return;
                }
                o43 y = M.y();
                if (y == null) {
                    mm3Var.a(null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("key_param_tpl_list", strArr);
                y.X(bundle, ao3.class, new c(mm3Var));
                return;
            }
            mm3Var.a(null);
        }
    }
}
