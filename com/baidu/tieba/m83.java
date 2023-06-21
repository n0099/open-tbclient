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
/* loaded from: classes6.dex */
public class m83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ i83 c;

        public a(Class cls, Bundle bundle, i83 i83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, bundle, i83Var};
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
            this.c = i83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle b = m83.b(this.a, this.b);
                i83 i83Var = this.c;
                if (i83Var != null) {
                    i83Var.onResult(b);
                }
            }
        }
    }

    public static void a(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle, @Nullable i83<Bundle> i83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cls, bundle, i83Var) == null) {
            to3.k(new a(cls, bundle, i83Var), "asyncCallMainProcess");
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
            u83 y = yb3.K().y();
            if (y != null && (S = y.S()) != null) {
                try {
                    Bundle callMainProcessSync = S.callMainProcessSync(cls.getName(), bundle);
                    if (callMainProcessSync == null) {
                        return new Bundle();
                    }
                    return callMainProcessSync;
                } catch (Throwable th) {
                    z82.d("SwanProcessCallManager", "callMainProcessSync", th);
                }
            }
            return DelegateUtils.callOnMainWithContentProvider(gv2.c(), cls, bundle).mResult;
        }
        return (Bundle) invokeLL.objValue;
    }

    @NonNull
    public static o83 c(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, bundle)) == null) {
            return new o83(b(cls, bundle));
        }
        return (o83) invokeLL.objValue;
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
            ProviderDelegation a2 = n83.a(cls);
            if (a2 == null) {
                try {
                    a2 = cls.newInstance();
                } catch (Exception e) {
                    z82.d("SwanProcessCallManager", "callOnMainProcess", e);
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
            ProviderDelegation b = n83.b(str);
            if (b == null) {
                try {
                    b = (ProviderDelegation) Class.forName(str).newInstance();
                } catch (Exception e) {
                    z82.d("SwanProcessCallManager", "callOnMainProcess", e);
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
