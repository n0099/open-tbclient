package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes6.dex */
public final class k8c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j + j2;
            if (j3 < 0) {
                return Long.MAX_VALUE;
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    public static long b(AtomicLong atomicLong, long j) {
        long j2;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, atomicLong, j)) == null) {
            do {
                j2 = atomicLong.get();
            } while (!atomicLong.compareAndSet(j2, a(j2, j)));
            return j2;
        }
        return invokeLJ.longValue;
    }

    public static long c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j * j2;
            if (((j | j2) >>> 31) != 0 && j2 != 0 && j3 / j2 != j) {
                return Long.MAX_VALUE;
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    /* JADX DEBUG: Type inference failed for r10v3. Raw type applied. Possible types: R, ? super R */
    /* JADX DEBUG: Type inference failed for r8v4. Raw type applied. Possible types: R, ? super R */
    public static <T, R> void d(AtomicLong atomicLong, Queue<T> queue, t7c<? super R> t7cVar, g8c<? super T, ? extends R> g8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, atomicLong, queue, t7cVar, g8cVar) == null) {
            long j = atomicLong.get();
            if (j == Long.MAX_VALUE) {
                while (!t7cVar.isUnsubscribed()) {
                    Object poll = queue.poll();
                    if (poll == null) {
                        t7cVar.onCompleted();
                        return;
                    }
                    t7cVar.onNext((R) g8cVar.call(poll));
                }
                return;
            }
            do {
                long j2 = Long.MIN_VALUE;
                while (true) {
                    int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i != 0) {
                        if (t7cVar.isUnsubscribed()) {
                            return;
                        }
                        Object poll2 = queue.poll();
                        if (poll2 == null) {
                            t7cVar.onCompleted();
                            return;
                        } else {
                            t7cVar.onNext((R) g8cVar.call(poll2));
                            j2++;
                        }
                    } else {
                        if (i == 0) {
                            if (t7cVar.isUnsubscribed()) {
                                return;
                            }
                            if (queue.isEmpty()) {
                                t7cVar.onCompleted();
                                return;
                            }
                        }
                        j = atomicLong.get();
                        if (j == j2) {
                            j = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                        }
                    }
                }
            } while (j != Long.MIN_VALUE);
        }
    }

    public static <T> boolean e(AtomicLong atomicLong, long j, Queue<T> queue, t7c<? super T> t7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{atomicLong, Long.valueOf(j), queue, t7cVar})) == null) {
            return f(atomicLong, j, queue, t7cVar, UtilityFunctions.b());
        }
        return invokeCommon.booleanValue;
    }

    public static <T, R> boolean f(AtomicLong atomicLong, long j, Queue<T> queue, t7c<? super R> t7cVar, g8c<? super T, ? extends R> g8cVar) {
        InterceptResult invokeCommon;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{atomicLong, Long.valueOf(j), queue, t7cVar, g8cVar})) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    if ((atomicLong.get() & Long.MIN_VALUE) == 0) {
                        return true;
                    }
                    return false;
                }
                while (true) {
                    j2 = atomicLong.get();
                    j3 = j2 & Long.MIN_VALUE;
                    if (atomicLong.compareAndSet(j2, a(Long.MAX_VALUE & j2, j) | j3)) {
                        break;
                    }
                }
                if (j2 == Long.MIN_VALUE) {
                    d(atomicLong, queue, t7cVar, g8cVar);
                    return false;
                } else if (j3 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
        return invokeCommon.booleanValue;
    }

    public static long g(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, atomicLong, j)) == null) {
            do {
                j2 = atomicLong.get();
                if (j2 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced than requested: " + j3);
                }
            } while (!atomicLong.compareAndSet(j2, j3));
            return j3;
        }
        return invokeLJ.longValue;
    }

    public static boolean h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
        return invokeJ.booleanValue;
    }
}
