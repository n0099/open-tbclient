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
/* loaded from: classes8.dex */
public class to3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qo3 a;

        public a(qo3 qo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qo3Var;
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
                oo3 oo3Var = new oo3();
                oo3Var.j(z);
                oo3Var.k(str);
                oo3Var.g(str2);
                oo3Var.h(z2);
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
                            oo3Var.i(14);
                        }
                    } else {
                        oo3Var.i(13);
                    }
                } else {
                    oo3Var.i(12);
                }
                this.a.a(QuickLoginInfo.parseQuickLoginInfo(oo3Var));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends q23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qo3 c;

        public b(qo3 qo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qo3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q23, com.baidu.tieba.r23, com.baidu.tieba.p23
        public void onEvent(@NonNull n23 n23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n23Var) == null) {
                Bundle a = n23Var.a();
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

    /* loaded from: classes8.dex */
    public static class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ so3 b;

        public c(Activity activity, so3 so3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, so3Var};
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
            this.b = so3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                gn3.a().m(this.a, oneKeyLoginResult.sign, this.b);
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

    /* loaded from: classes8.dex */
    public static class d implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so3 a;

        public d(so3 so3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = so3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                if (this.a != null) {
                    this.a.onResult(jj3.f(bundle, "quick_login", -1));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948187889, "Lcom/baidu/tieba/to3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948187889, "Lcom/baidu/tieba/to3;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public static void a(qo3 qo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, qo3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(qo3Var));
        }
    }

    public static void b(qo3 qo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qo3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(qo3Var);
            } else {
                c(qo3Var);
            }
        }
    }

    public static void c(qo3 qo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qo3Var) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                qo3Var.a(null);
                return;
            }
            f33 y = c0.y();
            if (y == null) {
                qo3Var.a(null);
            } else {
                y.X(null, po3.class, new b(qo3Var));
            }
        }
    }

    public static void d(Activity activity, int i, so3 so3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i, so3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, so3Var));
        }
    }

    public static void e(Activity activity, int i, so3 so3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, activity, i, so3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                d(activity, i, so3Var);
            } else {
                f(activity, i, so3Var);
            }
        }
    }

    public static void f(Activity activity, int i, so3 so3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, activity, i, so3Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("quick_login_mode", i);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, ro3.class, bundle, new d(so3Var));
        }
    }
}
