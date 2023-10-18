package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class r2<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] a;
    public int b;
    public boolean c;
    public a d;

    /* loaded from: classes7.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final r2<T> a;
        public final boolean b;
        public b c;
        public b d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(r2<T> r2Var) {
            this(r2Var, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((r2) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(r2<T> r2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = r2Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Iterable
        /* renamed from: a */
        public b<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (u2.a) {
                    return new b<>(this.a, this.b);
                }
                if (this.c == null) {
                    this.c = new b(this.a, this.b);
                    this.d = new b(this.a, this.b);
                }
                b<T> bVar = this.c;
                if (!bVar.d) {
                    bVar.c = 0;
                    bVar.d = true;
                    this.d.d = false;
                    return bVar;
                }
                b<T> bVar2 = this.d;
                bVar2.c = 0;
                bVar2.d = true;
                bVar.d = false;
                return bVar2;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final r2<T> a;
        public final boolean b;
        public int c;
        public boolean d;

        public b<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (b) invokeV.objValue;
        }

        public b(r2<T> r2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = true;
            this.a = r2Var;
            this.b = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.d) {
                    if (this.c < this.a.b) {
                        return true;
                    }
                    return false;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.b) {
                    int i = this.c - 1;
                    this.c = i;
                    this.a.f(i);
                    return;
                }
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.c;
                r2<T> r2Var = this.a;
                if (i < r2Var.b) {
                    if (this.d) {
                        T[] tArr = r2Var.a;
                        this.c = i + 1;
                        return tArr[i];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.c));
            }
            return (T) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r2() {
        this(true, 16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r2(int i) {
        this(true, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!this.c || !(obj instanceof r2)) {
                return false;
            }
            r2 r2Var = (r2) obj;
            if (!r2Var.c || (i = this.b) != r2Var.b) {
                return false;
            }
            T[] tArr = this.a;
            T[] tArr2 = r2Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                T t2 = tArr2[i2];
                if (t == null) {
                    if (t2 != null) {
                        return false;
                    }
                } else if (!t.equals(t2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public T f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int i2 = this.b;
            if (i < i2) {
                T[] tArr = this.a;
                T t = tArr[i];
                int i3 = i2 - 1;
                this.b = i3;
                if (this.c) {
                    System.arraycopy(tArr, i + 1, tArr, i, i3 - i);
                } else {
                    tArr[i] = tArr[i3];
                }
                tArr[this.b] = null;
                return t;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return (T) invokeI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r2(r2<? extends T> r2Var) {
        this(r2Var.c, r2Var.b, r2Var.a.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r2Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int i3 = r2Var.b;
        this.b = i3;
        System.arraycopy(r2Var.a, 0, this.a, 0, i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r2(Class cls) {
        this(true, 16, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public r2(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = (T[]) new Object[i];
    }

    public boolean g(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, t, z)) == null) {
            T[] tArr = this.a;
            if (!z && t != null) {
                int i = this.b;
                for (int i2 = 0; i2 < i; i2++) {
                    if (t.equals(tArr[i2])) {
                        f(i2);
                        return true;
                    }
                }
            } else {
                int i3 = this.b;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (tArr[i4] == t) {
                        f(i4);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public r2(boolean z, int i, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), cls};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = (T[]) ((Object[]) l3.a(cls, i));
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.a;
            int i = this.b;
            if (i == tArr.length) {
                tArr = h(Math.max(8, (int) (i * 1.75f)));
            }
            int i2 = this.b;
            this.b = i2 + 1;
            tArr[i2] = t;
        }
    }

    public void b(r2<? extends T> r2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r2Var) == null) {
            c(r2Var.a, 0, r2Var.b);
        }
    }

    public T[] h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            T[] tArr = this.a;
            T[] tArr2 = (T[]) ((Object[]) l3.a(tArr.getClass().getComponentType(), i));
            System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.b, tArr2.length));
            this.a = tArr2;
            return tArr2;
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, comparator) == null) {
            h3.a().b(this.a, comparator, 0, this.b);
        }
    }

    public void c(T[] tArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, tArr, i, i2) == null) {
            T[] tArr2 = this.a;
            int i3 = this.b + i2;
            if (i3 > tArr2.length) {
                tArr2 = h(Math.max(Math.max(8, i3), (int) (this.b * 1.75f)));
            }
            System.arraycopy(tArr, i, tArr2, this.b, i2);
            this.b = i3;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.a, 0, this.b, (Object) null);
            this.b = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: e */
    public b<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (u2.a) {
                return new b<>(this, true);
            }
            if (this.d == null) {
                this.d = new a(this);
            }
            return this.d.iterator();
        }
        return (b) invokeV.objValue;
    }

    public T first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.b != 0) {
                return this.a[0];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!this.c) {
                return super.hashCode();
            }
            T[] tArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 *= 31;
                T t = tArr[i3];
                if (t != null) {
                    i2 += t.hashCode();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.b == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i = this.b;
            if (i != 0) {
                int i2 = i - 1;
                this.b = i2;
                T[] tArr = this.a;
                T t = tArr[i2];
                tArr[i2] = null;
                return t;
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public void d(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, t) == null) {
            int i2 = this.b;
            if (i <= i2) {
                T[] tArr = this.a;
                if (i2 == tArr.length) {
                    tArr = h(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.c) {
                    System.arraycopy(tArr, i, tArr, i + 1, this.b - i);
                } else {
                    tArr[this.b] = tArr[i];
                }
                this.b++;
                tArr[i] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.b);
        }
    }

    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i < this.b) {
                return this.a[i];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return (T) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.b == 0) {
                return "[]";
            }
            T[] tArr = this.a;
            j3 j3Var = new j3(32);
            j3Var.a('[');
            j3Var.e(tArr[0]);
            for (int i = 1; i < this.b; i++) {
                j3Var.f(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j3Var.e(tArr[i]);
            }
            j3Var.a(']');
            return j3Var.toString();
        }
        return (String) invokeV.objValue;
    }
}
