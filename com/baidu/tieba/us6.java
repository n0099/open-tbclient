package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Comparable;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/* loaded from: classes8.dex */
public class us6<E extends Comparable<E>> extends AbstractList<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b<E> a;
    public int b;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<E> a;
        public boolean b;
        public b<E> c;
        public boolean d;
        public int e;
        public int f;
        public E g;

        public b(int i, E e, b<E> bVar, b<E> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), e, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i;
            this.g = e;
            this.d = true;
            this.b = true;
            this.c = bVar;
            this.a = bVar2;
        }

        public /* synthetic */ b(int i, Object obj, b bVar, b bVar2, a aVar) {
            this(i, obj, bVar, bVar2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Iterator) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (b) objArr2[4], (b) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(Collection collection, a aVar) {
            this(collection);
        }

        public final void A(b<E> bVar, b<E> bVar2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
                if (bVar == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.b = z;
                if (z) {
                    bVar = bVar2;
                }
                this.a = bVar;
                t();
            }
        }

        public final int B(b<E> bVar, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i)) == null) {
                if (bVar == null) {
                    return 0;
                }
                int i2 = i(bVar);
                bVar.f = i;
                return i2;
            }
            return invokeLI.intValue;
        }

        public final void C(b<E> bVar, b<E> bVar2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2) == null) {
                if (bVar == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.d = z;
                if (z) {
                    bVar = bVar2;
                }
                this.c = bVar;
                t();
            }
        }

        public void E(Object[] objArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, objArr, i) == null) {
                objArr[i] = this.g;
                if (h() != null) {
                    b<E> bVar = this.a;
                    bVar.E(objArr, bVar.f + i);
                }
                if (j() != null) {
                    b<E> bVar2 = this.c;
                    bVar2.E(objArr, i + bVar2.f);
                }
            }
        }

        public b<E> insert(int i, E e) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, e)) == null) {
                int i2 = i - this.f;
                if (i2 <= 0) {
                    return n(i2, e);
                }
                return o(i2, e);
            }
            return (b) invokeIL.objValue;
        }

        public b(Iterator<? extends E> it, int i, int i2, int i3, b<E> bVar, b<E> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bVar, bVar2};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            int i6 = i + ((i2 - i) / 2);
            if (i < i6) {
                this.a = new b<>(it, i, i6 - 1, i6, bVar, this);
            } else {
                this.b = true;
                this.a = bVar;
            }
            this.g = it.next();
            this.f = i6 - i3;
            if (i6 < i2) {
                this.c = new b<>(it, i6 + 1, i2, i6, this, bVar2);
            } else {
                this.d = true;
                this.c = bVar2;
            }
            t();
        }

        public void D(E e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, e) == null) {
                this.g = e;
            }
        }

        public b<E> f(int i) {
            InterceptResult invokeI;
            b<E> j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                int i2 = i - this.f;
                if (i2 == 0) {
                    return this;
                }
                if (i2 < 0) {
                    j = h();
                } else {
                    j = j();
                }
                if (j == null) {
                    return null;
                }
                return j.f(i2);
            }
            return (b) invokeI.objValue;
        }

        public final int g(b<E> bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
                if (bVar == null) {
                    return -1;
                }
                return bVar.e;
            }
            return invokeL.intValue;
        }

        public final int i(b<E> bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
                if (bVar == null) {
                    return 0;
                }
                return bVar.f;
            }
            return invokeL.intValue;
        }

        public final b<E> d(b<E> bVar, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bVar, i)) == null) {
                b<E> p = p();
                b<E> q = bVar.q();
                if (bVar.e > this.e) {
                    b<E> v = v();
                    ArrayDeque arrayDeque = new ArrayDeque();
                    b<E> bVar2 = bVar;
                    int i2 = bVar.f + i;
                    int i3 = 0;
                    while (bVar2 != null && bVar2.e > g(v)) {
                        arrayDeque.push(bVar2);
                        bVar2 = bVar2.a;
                        if (bVar2 != null) {
                            i3 = i2;
                            i2 = bVar2.f + i2;
                        } else {
                            i3 = i2;
                        }
                    }
                    p.A(v, null);
                    p.C(bVar2, q);
                    if (v != null) {
                        v.p().C(null, p);
                        v.f -= i - 1;
                    }
                    if (bVar2 != null) {
                        bVar2.q().A(null, p);
                        bVar2.f = (i2 - i) + 1;
                    }
                    p.f = (i - 1) - i3;
                    bVar.f += i;
                    while (!arrayDeque.isEmpty()) {
                        b bVar3 = (b) arrayDeque.pop();
                        bVar3.A(p, null);
                        p = bVar3.e();
                    }
                    return p;
                }
                b<E> w = bVar.w();
                ArrayDeque arrayDeque2 = new ArrayDeque();
                b<E> bVar4 = this;
                int i4 = this.f;
                int i5 = 0;
                while (bVar4 != null && bVar4.e > g(w)) {
                    arrayDeque2.push(bVar4);
                    bVar4 = bVar4.c;
                    if (bVar4 != null) {
                        int i6 = i4;
                        i4 = bVar4.f + i4;
                        i5 = i6;
                    } else {
                        i5 = i4;
                    }
                }
                q.C(w, null);
                q.A(bVar4, p);
                if (w != null) {
                    w.q().A(null, q);
                    w.f++;
                }
                if (bVar4 != null) {
                    bVar4.p().C(null, q);
                    bVar4.f = i4 - i;
                }
                q.f = i - i5;
                while (!arrayDeque2.isEmpty()) {
                    b bVar5 = (b) arrayDeque2.pop();
                    bVar5.C(q, null);
                    q = bVar5.e();
                }
                return q;
            }
            return (b) invokeLI.objValue;
        }

        public final b<E> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int l = l();
                if (l != -2) {
                    if (l != -1 && l != 0 && l != 1) {
                        if (l == 2) {
                            if (this.c.l() < 0) {
                                C(this.c.z(), null);
                            }
                            return y();
                        }
                        throw new RuntimeException("tree inconsistent!");
                    }
                    return this;
                }
                if (this.a.l() > 0) {
                    A(this.a.y(), null);
                }
                return z();
            }
            return (b) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("AVLNode(");
                sb.append(this.f);
                sb.append(",");
                boolean z2 = true;
                if (this.a != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append(",");
                sb.append(this.g);
                sb.append(",");
                if (j() == null) {
                    z2 = false;
                }
                sb.append(z2);
                sb.append(", faedelung ");
                sb.append(this.d);
                sb.append(" )");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final b<E> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.b) {
                    return null;
                }
                return this.a;
            }
            return (b) invokeV.objValue;
        }

        public final b<E> j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.d) {
                    return null;
                }
                return this.c;
            }
            return (b) invokeV.objValue;
        }

        public E k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.g;
            }
            return (E) invokeV.objValue;
        }

        public final int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return g(j()) - g(h());
            }
            return invokeV.intValue;
        }

        public final b<E> p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                if (j() == null) {
                    return this;
                }
                return this.c.p();
            }
            return (b) invokeV.objValue;
        }

        public final b<E> q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                if (h() == null) {
                    return this;
                }
                return this.a.q();
            }
            return (b) invokeV.objValue;
        }

        public b<E> r() {
            InterceptResult invokeV;
            b<E> bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                if (!this.d && (bVar = this.c) != null) {
                    return bVar.q();
                }
                return this.c;
            }
            return (b) invokeV.objValue;
        }

        public b<E> s() {
            InterceptResult invokeV;
            b<E> bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                if (!this.b && (bVar = this.a) != null) {
                    return bVar.p();
                }
                return this.a;
            }
            return (b) invokeV.objValue;
        }

        public int m(Object obj, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, obj, i)) == null) {
                if (h() != null) {
                    b<E> bVar = this.a;
                    int m = bVar.m(obj, bVar.f + i);
                    if (m != -1) {
                        return m;
                    }
                }
                if (Objects.equals(this.g, obj)) {
                    return i;
                }
                if (j() == null) {
                    return -1;
                }
                b<E> bVar2 = this.c;
                return bVar2.m(obj, i + bVar2.f);
            }
            return invokeLI.intValue;
        }

        public final b<E> n(int i, E e) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i, e)) == null) {
                if (h() == null) {
                    A(new b<>(-1, e, this, this.a), null);
                } else {
                    A(this.a.insert(i, e), null);
                }
                int i2 = this.f;
                if (i2 >= 0) {
                    this.f = i2 + 1;
                }
                b<E> e2 = e();
                t();
                return e2;
            }
            return (b) invokeIL.objValue;
        }

        public final b<E> o(int i, E e) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, e)) == null) {
                if (j() == null) {
                    C(new b<>(1, e, this.c, this), null);
                } else {
                    C(this.c.insert(i, e), null);
                }
                int i2 = this.f;
                if (i2 < 0) {
                    this.f = i2 - 1;
                }
                b<E> e2 = e();
                t();
                return e2;
            }
            return (b) invokeIL.objValue;
        }

        public final void t() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                int i2 = -1;
                if (h() == null) {
                    i = -1;
                } else {
                    i = h().e;
                }
                if (j() != null) {
                    i2 = j().e;
                }
                this.e = Math.max(i, i2) + 1;
            }
        }

        public final b<E> v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                if (j() == null) {
                    return x();
                }
                C(this.c.v(), this.c.c);
                int i = this.f;
                if (i < 0) {
                    this.f = i + 1;
                }
                t();
                return e();
            }
            return (b) invokeV.objValue;
        }

        public final b<E> w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if (h() == null) {
                    return x();
                }
                A(this.a.w(), this.a.a);
                int i = this.f;
                if (i > 0) {
                    this.f = i - 1;
                }
                t();
                return e();
            }
            return (b) invokeV.objValue;
        }

        public final b<E> y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                b<E> bVar = this.c;
                b<E> h = j().h();
                int i = this.f + i(bVar);
                C(h, bVar);
                bVar.A(this, null);
                B(bVar, i);
                B(this, -bVar.f);
                B(h, i(bVar) + i(h));
                return bVar;
            }
            return (b) invokeV.objValue;
        }

        public final b<E> z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                b<E> bVar = this.a;
                b<E> j = h().j();
                int i = this.f + i(bVar);
                A(j, bVar);
                bVar.C(this, null);
                B(bVar, i);
                B(this, -bVar.f);
                B(j, i(bVar) + i(j));
                return bVar;
            }
            return (b) invokeV.objValue;
        }

        public b<E> u(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
                int i2 = i - this.f;
                if (i2 == 0) {
                    return x();
                }
                if (i2 > 0) {
                    C(this.c.u(i2), this.c.c);
                    int i3 = this.f;
                    if (i3 < 0) {
                        this.f = i3 + 1;
                    }
                } else {
                    A(this.a.u(i2), this.a.a);
                    int i4 = this.f;
                    if (i4 > 0) {
                        this.f = i4 - 1;
                    }
                }
                t();
                return e();
            }
            return (b) invokeI.objValue;
        }

        public final b<E> x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                if (j() == null && h() == null) {
                    return null;
                }
                if (j() == null) {
                    int i = this.f;
                    if (i > 0) {
                        this.a.f += i;
                    }
                    this.a.p().C(null, this.c);
                    return this.a;
                }
                int i2 = 1;
                if (h() == null) {
                    b<E> bVar = this.c;
                    int i3 = bVar.f;
                    int i4 = this.f;
                    if (i4 < 0) {
                        i2 = 0;
                    }
                    bVar.f = i3 + (i4 - i2);
                    this.c.q().A(null, this.a);
                    return this.c;
                }
                if (l() > 0) {
                    b<E> q = this.c.q();
                    this.g = q.g;
                    if (this.b) {
                        this.a = q.a;
                    }
                    this.c = this.c.w();
                    int i5 = this.f;
                    if (i5 < 0) {
                        this.f = i5 + 1;
                    }
                } else {
                    b<E> p = this.a.p();
                    this.g = p.g;
                    if (this.d) {
                        this.c = p.c;
                    }
                    b<E> bVar2 = this.a;
                    b<E> bVar3 = bVar2.a;
                    b<E> v = bVar2.v();
                    this.a = v;
                    if (v == null) {
                        this.a = bVar3;
                        this.b = true;
                    }
                    int i6 = this.f;
                    if (i6 > 0) {
                        this.f = i6 - 1;
                    }
                }
                t();
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c<E extends Comparable<E>> implements ListIterator<E>, Object<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final us6<E> a;
        public b<E> b;
        public int c;
        public b<E> d;
        public int e;
        public int f;

        public c(us6<E> us6Var, int i) throws IndexOutOfBoundsException {
            b<E> f;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us6Var;
            this.f = ((AbstractList) us6Var).modCount;
            if (us6Var.a == null) {
                f = null;
            } else {
                f = us6Var.a.f(i);
            }
            this.b = f;
            this.c = i;
            this.e = -1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(E e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e) == null) {
                b();
                this.a.add(this.c, e);
                this.d = null;
                this.e = -1;
                this.c++;
                this.f++;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(E e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, e) == null) {
                b();
                b<E> bVar = this.d;
                if (bVar != null) {
                    bVar.D(e);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || ((AbstractList) this.a).modCount == this.f) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.c < this.a.size()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.c > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return nextIndex() - 1;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c */
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                b();
                if (hasNext()) {
                    if (this.b == null) {
                        this.b = this.a.a.f(this.c);
                    }
                    E k = this.b.k();
                    b<E> bVar = this.b;
                    this.d = bVar;
                    int i = this.c;
                    this.c = i + 1;
                    this.e = i;
                    this.b = bVar.r();
                    return k;
                }
                throw new NoSuchElementException("No element at index " + this.c + ".");
            }
            return (E) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: d */
        public E previous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                b();
                if (hasPrevious()) {
                    b<E> bVar = this.b;
                    if (bVar == null) {
                        this.b = this.a.a.f(this.c - 1);
                    } else {
                        this.b = bVar.s();
                    }
                    E k = this.b.k();
                    this.d = this.b;
                    int i = this.c - 1;
                    this.c = i;
                    this.e = i;
                    return k;
                }
                throw new NoSuchElementException("Already at start of list.");
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                b();
                int i = this.e;
                if (i != -1) {
                    this.a.remove(i);
                    int i2 = this.c;
                    if (i2 != this.e) {
                        this.c = i2 - 1;
                    }
                    this.b = null;
                    this.d = null;
                    this.e = -1;
                    this.f++;
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public us6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((AbstractList) this).modCount++;
            this.a = null;
            this.b = 0;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NonNull
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return listIterator(0);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return listIterator(0);
        }
        return (ListIterator) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NonNull
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Object[] objArr = new Object[size()];
            b<E> bVar = this.a;
            if (bVar != null) {
                bVar.E(objArr, bVar.f);
            }
            return objArr;
        }
        return (Object[]) invokeV.objValue;
    }

    public us6(Collection<? extends E> collection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (!collection.isEmpty()) {
            this.a = new b<>(collection, null);
            this.b = collection.size();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            if (collection.isEmpty()) {
                return false;
            }
            ((AbstractList) this).modCount += collection.size();
            b<E> bVar = new b<>(collection, null);
            b<E> bVar2 = this.a;
            if (bVar2 != null) {
                bVar = bVar2.d(bVar, this.b);
            }
            this.a = bVar;
            this.b += collection.size();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public E remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ((AbstractList) this).modCount++;
            e(i, 0, size() - 1);
            E e = get(i);
            this.a = this.a.u(i);
            this.b--;
            return e;
        }
        return (E) invokeI.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (indexOf(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f */
    public E get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            e(i, 0, size() - 1);
            return this.a.f(i).k();
        }
        return (E) invokeI.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            b<E> bVar = this.a;
            if (bVar == null) {
                return -1;
            }
            return bVar.m(obj, bVar.f);
        }
        return invokeL.intValue;
    }

    @Override // java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            e(i, 0, size());
            return new c(this, i);
        }
        return (ListIterator) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public E set(int i, E e) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, e)) == null) {
            e(i, 0, size() - 1);
            b<E> f = this.a.f(i);
            E e2 = (E) f.g;
            f.D(e);
            return e2;
        }
        return (E) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i, E e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, e) == null) {
            ((AbstractList) this).modCount++;
            e(i, 0, size());
            b<E> bVar = this.a;
            if (bVar == null) {
                this.a = new b<>(i, e, null, null, null);
            } else {
                this.a = bVar.insert(i, e);
            }
            this.b++;
        }
    }

    public final void e(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            if (i >= i2 && i <= i3) {
                return;
            }
            throw new IndexOutOfBoundsException("Invalid index:" + i + ", size=" + size());
        }
    }
}
