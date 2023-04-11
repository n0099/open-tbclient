package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes5.dex */
public class og3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, ng3> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948031246, "Lcom/baidu/tieba/og3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948031246, "Lcom/baidu/tieba/og3;");
                return;
            }
        }
        a = eo1.a;
        b = new ArrayMap();
    }

    @Nullable
    public static AshmemFileDescriptor a(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            try {
                if (ProcessUtils.isMainProcess()) {
                    synchronized (b) {
                        ng3 ng3Var = b.get(str);
                        if (ng3Var != null && ng3Var.a() != null) {
                            return ng3Var.a();
                        }
                        int ashmemFD = SwanKV.getAshmemFD(str, i);
                        if (ashmemFD >= 0) {
                            AshmemFileDescriptor ashmemFileDescriptor = new AshmemFileDescriptor(str, ashmemFD, i);
                            kg3.e(ashmemFileDescriptor);
                            return ashmemFileDescriptor;
                        }
                        return null;
                    }
                }
                return jg3.c(str, i);
            } catch (Throwable th) {
                if (a) {
                    th.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (AshmemFileDescriptor) invokeLI.objValue;
    }

    public static synchronized void b(@NonNull AshmemFileDescriptor ashmemFileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ashmemFileDescriptor) == null) {
            synchronized (og3.class) {
                if (ProcessUtils.isMainProcess()) {
                    return;
                }
                ng3 ng3Var = b.get(ashmemFileDescriptor.getName());
                if (ng3Var != null && ng3Var.a() != null && ng3Var.a().getAshmemFD() != ashmemFileDescriptor.getAshmemFD()) {
                    SwanKV b2 = ng3Var.b();
                    ng3Var.c(new SwanKV(ashmemFileDescriptor));
                    b2.release();
                }
            }
        }
    }
}
