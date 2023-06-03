package com.baidu.tieba;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class ol1 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, ol1> a;
    public static final ConcurrentHashMap<String, b> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract IBinder c();

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IBinder a;
        public boolean b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = false;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948035989, "Lcom/baidu/tieba/ol1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948035989, "Lcom/baidu/tieba/ol1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new ConcurrentHashMap<>();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || Binder.getCallingUid() == Process.myUid()) {
            return;
        }
        throw new SecurityException();
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, null, str, iBinder, z) == null) {
            if (Binder.getCallingUid() == Process.myUid()) {
                if (a.get(str) == null) {
                    b bVar = new b(null);
                    bVar.a = iBinder;
                    bVar.b = z;
                    b.put(str, bVar);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new SecurityException();
        }
    }

    public static IBinder d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ol1 ol1Var = a.get(str);
            if (ol1Var != null) {
                ol1Var.b();
                return ol1Var.c();
            }
            b bVar = b.get(str);
            if (bVar != null) {
                if (!bVar.b && Binder.getCallingUid() != Process.myUid()) {
                    throw new SecurityException();
                }
                return bVar.a;
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (Binder.getCallingUid() == Process.myUid()) {
                if (b.remove(str) != null) {
                    return true;
                }
                return false;
            }
            throw new SecurityException();
        }
        return invokeL.booleanValue;
    }
}
