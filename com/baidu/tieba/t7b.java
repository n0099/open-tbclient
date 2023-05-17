package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.List;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class t7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Throwable th, Throwable th2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, th, th2) == null) {
            HashSet hashSet = new HashSet();
            int i = 0;
            while (th.getCause() != null) {
                int i2 = i + 1;
                if (i >= 25) {
                    return;
                }
                th = th.getCause();
                if (!hashSet.contains(th.getCause())) {
                    hashSet.add(th.getCause());
                    i = i2;
                }
            }
            try {
                th.initCause(th2);
            } catch (Throwable unused) {
            }
        }
    }

    public static Throwable b(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            int i = 0;
            while (th.getCause() != null) {
                int i2 = i + 1;
                if (i >= 25) {
                    return new RuntimeException("Stack too deep to get final cause");
                }
                th = th.getCause();
                i = i2;
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static RuntimeException c(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            if (!(th instanceof RuntimeException)) {
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
        return (RuntimeException) invokeL.objValue;
    }

    public static void d(List<? extends Throwable> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, list) == null) && list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th = list.get(0);
                if (!(th instanceof RuntimeException)) {
                    if (th instanceof Error) {
                        throw ((Error) th);
                    }
                    throw new RuntimeException(th);
                }
                throw ((RuntimeException) th);
            }
            throw new CompositeException(list);
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) {
            if (!(th instanceof OnErrorNotImplementedException)) {
                if (!(th instanceof OnErrorFailedException)) {
                    if (!(th instanceof OnCompletedFailedException)) {
                        if (!(th instanceof VirtualMachineError)) {
                            if (!(th instanceof ThreadDeath)) {
                                if (!(th instanceof LinkageError)) {
                                    return;
                                }
                                throw ((LinkageError) th);
                            }
                            throw ((ThreadDeath) th);
                        }
                        throw ((VirtualMachineError) th);
                    }
                    throw ((OnCompletedFailedException) th);
                }
                throw ((OnErrorFailedException) th);
            }
            throw ((OnErrorNotImplementedException) th);
        }
    }

    public static void f(Throwable th, i7b<?> i7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, th, i7bVar) == null) {
            e(th);
            i7bVar.onError(th);
        }
    }

    public static void g(Throwable th, i7b<?> i7bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, th, i7bVar, obj) == null) {
            e(th);
            i7bVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
        }
    }

    public static void h(Throwable th, m7b<?> m7bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, th, m7bVar, obj) == null) {
            e(th);
            m7bVar.b(OnErrorThrowable.addValueAsLastCause(th, obj));
        }
    }
}
