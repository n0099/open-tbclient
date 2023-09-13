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
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class r7<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public T[] b;
    public float c;
    public int d;
    public int e;
    public int f;
    public transient a g;
    public transient a h;

    /* loaded from: classes7.dex */
    public static class a<K> implements Iterable<K>, Iterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final r7<K> b;
        public int c;
        public int d;
        public boolean e;

        public a<K> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (a) invokeV.objValue;
        }

        public a(r7<K> r7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = true;
            this.b = r7Var;
            c();
        }

        public final void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.b.b;
                int length = kArr.length;
                do {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (kArr[i] == null);
                this.a = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = -1;
                this.c = -1;
                a();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            b();
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        K[] kArr = this.b.b;
                        int i = this.c;
                        K k = kArr[i];
                        this.d = i;
                        a();
                        return k;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                int i = this.d;
                if (i >= 0) {
                    r7<K> r7Var = this.b;
                    K[] kArr = r7Var.b;
                    int i2 = r7Var.f;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        K k = kArr[i4];
                        if (k == null) {
                            break;
                        }
                        int f = this.b.f(k);
                        if (((i4 - f) & i2) > ((i - f) & i2)) {
                            kArr[i] = k;
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    r7<K> r7Var2 = this.b;
                    r7Var2.a--;
                    if (i != this.d) {
                        this.c--;
                    }
                    this.d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r7() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r7(int i) {
        this(i, 0.8f);
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
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String i(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.a == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(32);
            T[] tArr = this.b;
            int length = tArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                T t = tArr[i];
                if (t == null) {
                    length = i;
                } else {
                    if (t == this) {
                        t = "(this)";
                    }
                    sb.append(t);
                }
            }
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    T t2 = tArr[i2];
                    if (t2 != null) {
                        sb.append(str);
                        if (t2 == this) {
                            t2 = "(this)";
                        }
                        sb.append(t2);
                    }
                    i = i2;
                } else {
                    return sb.toString();
                }
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public r7(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (f > 0.0f && f < 1.0f) {
            this.c = f;
            int h = h(i, f);
            this.d = (int) (h * f);
            int i4 = h - 1;
            this.f = i4;
            this.e = Long.numberOfLeadingZeros(i4);
            this.b = (T[]) new Object[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public static int h(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            if (i >= 0) {
                int j = com.badlogic.gdx.math.d.j(Math.max(2, (int) Math.ceil(i / f)));
                if (j <= 1073741824) {
                    return j;
                }
                throw new IllegalArgumentException("The required capacity is too large: " + i);
            }
            throw new IllegalArgumentException("capacity must be >= 0: " + i);
        }
        return invokeCommon.intValue;
    }

    public final void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.b;
            int f = f(t);
            while (tArr[f] != null) {
                f = (f + 1) & this.f;
            }
            tArr[f] = t;
        }
    }

    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            int e = e(t);
            if (e >= 0) {
                return false;
            }
            T[] tArr = this.b;
            tArr[-(e + 1)] = t;
            int i = this.a + 1;
            this.a = i;
            if (i >= this.d) {
                g(tArr.length << 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int h = h(i, this.c);
            if (this.b.length <= h) {
                clear();
                return;
            }
            this.a = 0;
            g(h);
        }
    }

    public void c(int i) {
        int h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.b.length < (h = h(this.a + i, this.c))) {
            g(h);
        }
    }

    public boolean contains(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            if (e(t) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            return (int) ((t.hashCode() * (-7046029254386353131L)) >>> this.e);
        }
        return invokeL.intValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == 0) {
            return;
        }
        this.a = 0;
        Arrays.fill(this.b, (Object) null);
    }

    public int hashCode() {
        InterceptResult invokeV;
        T[] tArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.a;
            for (T t : this.b) {
                if (t != null) {
                    i += t.hashCode();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return '{' + i(StringUtil.ARRAY_ELEMENT_SEPARATOR) + '}';
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: d */
    public a<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (z6.a) {
                return new a<>(this);
            }
            if (this.g == null) {
                this.g = new a(this);
                this.h = new a(this);
            }
            a aVar = this.g;
            if (!aVar.e) {
                aVar.c();
                a<T> aVar2 = this.g;
                aVar2.e = true;
                this.h.e = false;
                return aVar2;
            }
            this.h.c();
            a<T> aVar3 = this.h;
            aVar3.e = true;
            this.g.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public int e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            if (t != null) {
                T[] tArr = this.b;
                int f = f(t);
                while (true) {
                    T t2 = tArr[f];
                    if (t2 == null) {
                        return -(f + 1);
                    }
                    if (t2.equals(t)) {
                        return f;
                    }
                    f = (f + 1) & this.f;
                }
            } else {
                throw new IllegalArgumentException("key cannot be null.");
            }
        } else {
            return invokeL.intValue;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (!(obj instanceof r7)) {
                return false;
            }
            r7 r7Var = (r7) obj;
            if (r7Var.a != this.a) {
                return false;
            }
            T[] tArr = this.b;
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (tArr[i] != null && !r7Var.contains(tArr[i])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            int length = this.b.length;
            this.d = (int) (i * this.c);
            int i2 = i - 1;
            this.f = i2;
            this.e = Long.numberOfLeadingZeros(i2);
            T[] tArr = this.b;
            this.b = (T[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    T t = tArr[i3];
                    if (t != null) {
                        a(t);
                    }
                }
            }
        }
    }

    public boolean remove(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, t)) == null) {
            int e = e(t);
            if (e < 0) {
                return false;
            }
            T[] tArr = this.b;
            int i = this.f;
            int i2 = e + 1;
            while (true) {
                int i3 = i2 & i;
                T t2 = tArr[i3];
                if (t2 != null) {
                    int f = f(t2);
                    if (((i3 - f) & i) > ((e - f) & i)) {
                        tArr[e] = t2;
                        e = i3;
                    }
                    i2 = i3 + 1;
                } else {
                    tArr[e] = null;
                    this.a--;
                    return true;
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }
}
