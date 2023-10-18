package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn3 a;

        public a(vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                super.unAvailable(oneKeyLoginResult);
                this.a.a(null);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                if (oneKeyLoginResult == null) {
                    this.a.a(null);
                    return;
                }
                boolean z = oneKeyLoginResult.enable;
                String str = oneKeyLoginResult.operator;
                String str2 = oneKeyLoginResult.encryptPhoneNum;
                boolean z2 = oneKeyLoginResult.hasHistory;
                tn3 tn3Var = new tn3();
                tn3Var.j(z);
                tn3Var.k(str);
                tn3Var.g(str2);
                tn3Var.h(z2);
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 2154) {
                    if (hashCode != 2161) {
                        if (hashCode == 2162 && str.equals("CU")) {
                            c = 1;
                        }
                    } else if (str.equals("CT")) {
                        c = 2;
                    }
                } else if (str.equals("CM")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2) {
                            tn3Var.i(14);
                        }
                    } else {
                        tn3Var.i(13);
                    }
                } else {
                    tn3Var.i(12);
                }
                this.a.a(QuickLoginInfo.parseQuickLoginInfo(tn3Var));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends v13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn3 c;

        public b(vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vn3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v13, com.baidu.tieba.w13, com.baidu.tieba.u13
        public void onEvent(@NonNull s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s13Var) == null) {
                Bundle a = s13Var.a();
                if (a == null) {
                    this.c.a(null);
                    return;
                }
                a.setClassLoader(QuickLoginInfo.class.getClassLoader());
                QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a.getParcelable("quick_login_info_result");
                if (quickLoginInfo == null) {
                    this.c.a(null);
                } else {
                    this.c.a(quickLoginInfo);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ xn3 b;

        public c(Activity activity, xn3 xn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, xn3Var};
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
            this.b = xn3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                lm3.a().m(this.a, oneKeyLoginResult.sign, this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.b.onResult(-1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn3 a;

        public d(xn3 xn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                if (this.a != null) {
                    this.a.onResult(oi3.f(bundle, "quick_login", -1));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948335883, "Lcom/baidu/tieba/yn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948335883, "Lcom/baidu/tieba/yn3;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public static void a(vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, vn3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(vn3Var));
        }
    }

    public static void b(vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, vn3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(vn3Var);
            } else {
                c(vn3Var);
            }
        }
    }

    public static void c(vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, vn3Var) == null) {
            p53 c0 = p53.c0();
            if (c0 == null) {
                vn3Var.a(null);
                return;
            }
            k23 y = c0.y();
            if (y == null) {
                vn3Var.a(null);
            } else {
                y.X(null, un3.class, new b(vn3Var));
            }
        }
    }

    public static void d(Activity activity, int i, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i, xn3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, xn3Var));
        }
    }

    public static void e(Activity activity, int i, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, activity, i, xn3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                d(activity, i, xn3Var);
            } else {
                f(activity, i, xn3Var);
            }
        }
    }

    public static void f(Activity activity, int i, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, activity, i, xn3Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("quick_login_mode", i);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, wn3.class, bundle, new d(xn3Var));
        }
    }
}
