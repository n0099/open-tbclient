package com.baidu.tieba;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-538527268, "Lcom/baidu/tieba/q32$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-538527268, "Lcom/baidu/tieba/q32$a;");
                    return;
                }
            }
            int[] iArr = new int[BasePendingOperation.OperationType.values().length];
            a = iArr;
            try {
                iArr[BasePendingOperation.OperationType.OPERATION_TYPE_MAIN_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static m32 a(BasePendingOperation.OperationType operationType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, operationType)) == null) {
            int i = a.a[operationType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return new r32();
                }
                return new p32();
            }
            return new o32();
        }
        return (m32) invokeL.objValue;
    }
}
