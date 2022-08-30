package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class yn9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Object b;
    @Nullable
    public static volatile yn9 c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948336069, "Lcom/baidu/tieba/yn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948336069, "Lcom/baidu/tieba/yn9;");
                return;
            }
        }
        b = new Object();
    }

    public yn9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }

    @NonNull
    public static yn9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (b) {
                    if (c == null) {
                        c = new yn9();
                    }
                }
            }
            yn9 yn9Var = c;
            jn9.d(yn9Var);
            return yn9Var;
        }
        return (yn9) invokeV.objValue;
    }

    public static void b(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, serviceConnection) == null) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        }
    }

    public static boolean d(ServiceConnection serviceConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, serviceConnection)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean e(Context context, Intent intent, ServiceConnection serviceConnection, int i, @Nullable Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, intent, serviceConnection, Integer.valueOf(i), executor})) == null) ? (!bo9.f() || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection) : invokeCommon.booleanValue;
    }

    public boolean bindService(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, intent, serviceConnection, i)) == null) ? c(context, context.getClass().getName(), intent, serviceConnection, i, true, null) : invokeLLLI.booleanValue;
    }

    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, @Nullable Executor executor) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, intent, serviceConnection, Integer.valueOf(i), Boolean.valueOf(z), executor})) == null) {
            ComponentName component = intent.getComponent();
            if (component != null) {
                String packageName = component.getPackageName();
                "com.google.android.gms".equals(packageName);
                try {
                    if ((fo9.a(context).a(packageName, 0).flags & 2097152) != 0) {
                        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                        return false;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (d(serviceConnection)) {
                ServiceConnection putIfAbsent = this.a.putIfAbsent(serviceConnection, serviceConnection);
                if (putIfAbsent != null && serviceConnection != putIfAbsent) {
                    Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
                }
                try {
                    boolean e = e(context, intent, serviceConnection, i, executor);
                    if (e) {
                        return e;
                    }
                    return false;
                } finally {
                    this.a.remove(serviceConnection, serviceConnection);
                }
            }
            return e(context, intent, serviceConnection, i, executor);
        }
        return invokeCommon.booleanValue;
    }

    public void unbindService(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, serviceConnection) == null) {
            if (d(serviceConnection) && this.a.containsKey(serviceConnection)) {
                try {
                    b(context, this.a.get(serviceConnection));
                    return;
                } finally {
                    this.a.remove(serviceConnection);
                }
            }
            b(context, serviceConnection);
        }
    }
}
