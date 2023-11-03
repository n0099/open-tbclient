package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ p23 c;

        public a(Class cls, Bundle bundle, p23 p23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, bundle, p23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cls;
            this.b = bundle;
            this.c = p23Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle b = t23.b(this.a, this.b);
                p23 p23Var = this.c;
                if (p23Var != null) {
                    p23Var.onResult(b);
                }
            }
        }
    }

    public static void a(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle, @Nullable p23<Bundle> p23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cls, bundle, p23Var) == null) {
            aj3.k(new a(cls, bundle, p23Var), "asyncCallMainProcess");
        }
    }

    @NonNull
    public static Bundle b(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        IProcessBridge S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                Bundle d = d(cls, bundle);
                if (d == null) {
                    return new Bundle();
                }
                return d;
            }
            b33 y = f63.K().y();
            if (y != null && (S = y.S()) != null) {
                try {
                    Bundle callMainProcessSync = S.callMainProcessSync(cls.getName(), bundle);
                    if (callMainProcessSync == null) {
                        return new Bundle();
                    }
                    return callMainProcessSync;
                } catch (Throwable th) {
                    g32.d("SwanProcessCallManager", "callMainProcessSync", th);
                }
            }
            return DelegateUtils.callOnMainWithContentProvider(np2.c(), cls, bundle).mResult;
        }
        return (Bundle) invokeLL.objValue;
    }

    @NonNull
    public static v23 c(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, bundle)) == null) {
            return new v23(b(cls, bundle));
        }
        return (v23) invokeLL.objValue;
    }

    @Nullable
    @SuppressLint({"BDThrowableCheck"})
    public static Bundle d(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, bundle)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return null;
            }
            ProviderDelegation a2 = u23.a(cls);
            if (a2 == null) {
                try {
                    a2 = cls.newInstance();
                } catch (Exception e) {
                    g32.d("SwanProcessCallManager", "callOnMainProcess", e);
                }
            }
            if (a2 == null) {
                return null;
            }
            return a2.execCall(bundle);
        }
        return (Bundle) invokeLL.objValue;
    }

    @Nullable
    @SuppressLint({"BDThrowableCheck"})
    public static Bundle e(@NonNull String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bundle)) == null) {
            if (!ProcessUtils.isMainProcess()) {
                return null;
            }
            ProviderDelegation b = u23.b(str);
            if (b == null) {
                try {
                    b = (ProviderDelegation) Class.forName(str).newInstance();
                } catch (Exception e) {
                    g32.d("SwanProcessCallManager", "callOnMainProcess", e);
                }
            }
            if (b == null) {
                return null;
            }
            return b.execCall(bundle);
        }
        return (Bundle) invokeLL.objValue;
    }
}
