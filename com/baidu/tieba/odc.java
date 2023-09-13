package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class odc<T> implements Queue<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicLong a;
    public int b;
    public long c;
    public int d;
    public AtomicReferenceArray<Object> e;
    public int f;
    public AtomicReferenceArray<Object> g;
    public final AtomicLong h;

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 : invokeI.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029851, "Lcom/baidu/tieba/odc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029851, "Lcom/baidu/tieba/odc;");
                return;
            }
        }
        i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        j = new Object();
    }

    @Override // java.util.Queue
    public T poll() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.g;
            long d = d();
            int i2 = this.f;
            int c = c(d, i2);
            T t = (T) g(atomicReferenceArray, c);
            if (t == j) {
                z = true;
            } else {
                z = false;
            }
            if (t != null && !z) {
                o(atomicReferenceArray, c, null);
                n(d + 1);
                return t;
            } else if (!z) {
                return null;
            } else {
                return k(h(atomicReferenceArray), d, i2);
            }
        }
        return (T) invokeV.objValue;
    }

    public odc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int b = zdc.b(i2);
        int i5 = b - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b + 1);
        this.e = atomicReferenceArray;
        this.d = i5;
        a(b);
        this.g = atomicReferenceArray;
        this.f = i5;
        this.c = i5 - 1;
        this.a = new AtomicLong();
        this.h = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, t)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.e;
            long e = e();
            int i2 = this.d;
            int c = c(e, i2);
            if (e < this.c) {
                return r(atomicReferenceArray, t, e, c);
            }
            long j2 = this.b + e;
            if (g(atomicReferenceArray, c(j2, i2)) == null) {
                this.c = j2 - 1;
                return r(atomicReferenceArray, t, e, c);
            } else if (g(atomicReferenceArray, c(1 + e, i2)) == null) {
                return r(atomicReferenceArray, t, e, c);
            } else {
                m(atomicReferenceArray, e, c, t, i2);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static int c(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            int i3 = ((int) j2) & i2;
            b(i3);
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReferenceArray, i2)) == null) {
            return atomicReferenceArray.get(i2);
        }
        return invokeLI.objValue;
    }

    public final void p(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, atomicReferenceArray, atomicReferenceArray2) == null) {
            int length = atomicReferenceArray.length() - 1;
            b(length);
            o(atomicReferenceArray, length, atomicReferenceArray2);
        }
    }

    public static void o(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, atomicReferenceArray, i2, obj) == null) {
            atomicReferenceArray.lazySet(i2, obj);
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.b = Math.min(i2 / 4, i);
        }
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    public final AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, atomicReferenceArray)) == null) {
            int length = atomicReferenceArray.length() - 1;
            b(length);
            return (AtomicReferenceArray) g(atomicReferenceArray, length);
        }
        return (AtomicReferenceArray) invokeL.objValue;
    }

    public final void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.h.lazySet(j2);
        }
    }

    public final void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.a.lazySet(j2);
        }
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, eArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E[]) ((Object[]) invokeL.objValue);
    }

    @Override // java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h.get();
        }
        return invokeV.longValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.get();
        }
        return invokeV.longValue;
    }

    @Override // java.util.Queue
    public T element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeV.objValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h.get();
        }
        return invokeV.longValue;
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.get();
        }
        return invokeV.longValue;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (i() == f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.g;
            long d = d();
            int i2 = this.f;
            T t = (T) g(atomicReferenceArray, c(d, i2));
            if (t == j) {
                return j(h(atomicReferenceArray), d, i2);
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            long f = f();
            while (true) {
                long i2 = i();
                long f2 = f();
                if (f == f2) {
                    return (int) (i2 - f2);
                }
                f = f2;
            }
        } else {
            return invokeV.intValue;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Object[]) invokeV.objValue;
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{atomicReferenceArray, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            this.g = atomicReferenceArray;
            return (T) g(atomicReferenceArray, c(j2, i2));
        }
        return (T) invokeCommon.objValue;
    }

    public final T k(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{atomicReferenceArray, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            this.g = atomicReferenceArray;
            int c = c(j2, i2);
            T t = (T) g(atomicReferenceArray, c);
            if (t == null) {
                return null;
            }
            o(atomicReferenceArray, c, null);
            n(j2 + 1);
            return t;
        }
        return (T) invokeCommon.objValue;
    }

    public boolean l(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, t, t2)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.e;
            long i2 = i();
            int i3 = this.d;
            long j2 = 2 + i2;
            if (g(atomicReferenceArray, c(j2, i3)) == null) {
                int c = c(i2, i3);
                o(atomicReferenceArray, c + 1, t2);
                o(atomicReferenceArray, c, t);
                q(j2);
                return true;
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.e = atomicReferenceArray2;
            int c2 = c(i2, i3);
            o(atomicReferenceArray2, c2 + 1, t2);
            o(atomicReferenceArray2, c2, t);
            p(atomicReferenceArray, atomicReferenceArray2);
            o(atomicReferenceArray, c2, j);
            q(j2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void m(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{atomicReferenceArray, Long.valueOf(j2), Integer.valueOf(i2), t, Long.valueOf(j3)}) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.e = atomicReferenceArray2;
            this.c = (j3 + j2) - 1;
            o(atomicReferenceArray2, i2, t);
            p(atomicReferenceArray, atomicReferenceArray2);
            o(atomicReferenceArray, i2, j);
            q(j2 + 1);
        }
    }

    public final boolean r(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{atomicReferenceArray, t, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            o(atomicReferenceArray, i2, t);
            q(j2 + 1);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
