package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class q3<K, V> implements Iterable<b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public K[] b;
    public V[] c;
    public float d;
    public int e;
    public int f;
    public int g;
    public transient a h;
    public transient a i;
    public transient e j;
    public transient e k;
    public transient c l;
    public transient c m;

    /* loaded from: classes7.dex */
    public static class a<K, V> extends d<K, V, b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<K, V> f;

        public a<K, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q3<K, V> q3Var) {
            super(q3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((q3) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        q3<K, V> q3Var = this.b;
                        K[] kArr = q3Var.b;
                        b<K, V> bVar = this.f;
                        int i = this.c;
                        bVar.a = kArr[i];
                        bVar.b = q3Var.c[i];
                        this.d = i;
                        a();
                        return this.f;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            c();
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public K a;
        public V b;

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
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "=" + this.b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c<K> extends d<K, Object, K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c<K> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (c) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(q3<K, ?> q3Var) {
            super(q3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((q3) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            c();
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
    }

    /* loaded from: classes7.dex */
    public static abstract class d<K, V, I> implements Iterable<I>, Iterator<I> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final q3<K, V> b;
        public int c;
        public int d;
        public boolean e;

        public d(q3<K, V> q3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q3Var};
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
            this.b = q3Var;
            b();
        }

        public void a() {
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

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = -1;
                this.c = -1;
                a();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i >= 0) {
                    q3<K, V> q3Var = this.b;
                    K[] kArr = q3Var.b;
                    V[] vArr = q3Var.c;
                    int i2 = q3Var.g;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        K k = kArr[i4];
                        if (k == null) {
                            break;
                        }
                        int g = this.b.g(k);
                        if (((i4 - g) & i2) > ((i - g) & i2)) {
                            kArr[i] = k;
                            vArr[i] = vArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    vArr[i] = null;
                    q3<K, V> q3Var2 = this.b;
                    q3Var2.a--;
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

    /* loaded from: classes7.dex */
    public static class e<V> extends d<Object, V, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e<V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (e) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(q3<?, V> q3Var) {
            super(q3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((q3) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            c();
            return this;
        }

        @Override // java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        V[] vArr = this.b.c;
                        int i = this.c;
                        V v = vArr[i];
                        this.d = i;
                        a();
                        return v;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (V) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448313355, "Lcom/baidu/tieba/q3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448313355, "Lcom/baidu/tieba/q3;");
                return;
            }
        }
        n = new Object();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: d */
    public a<K, V> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return a();
        }
        return (a) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.a;
            K[] kArr = this.b;
            V[] vArr = this.c;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    i += k.hashCode();
                    V v = vArr[i2];
                    if (v != null) {
                        i += v.hashCode();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return l(StringUtil.ARRAY_ELEMENT_SEPARATOR, true);
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q3() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public q3(int i, float f) {
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
            this.d = f;
            int f2 = r3.f(i, f);
            this.e = (int) (f2 * f);
            int i4 = f2 - 1;
            this.g = i4;
            this.f = Long.numberOfLeadingZeros(i4);
            this.b = (K[]) new Object[f2];
            this.c = (V[]) new Object[f2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public String l(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            if (this.a == 0) {
                if (z) {
                    return "{}";
                }
                return "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            K[] kArr = this.b;
            Object[] objArr = this.c;
            int length = kArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                K k = kArr[i];
                if (k == null) {
                    length = i;
                } else {
                    if (k == this) {
                        k = "(this)";
                    }
                    sb.append(k);
                    sb.append('=');
                    Object obj = objArr[i];
                    if (obj == this) {
                        obj = "(this)";
                    }
                    sb.append(obj);
                }
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                K k2 = kArr[i2];
                if (k2 != null) {
                    sb.append(str);
                    if (k2 == this) {
                        k2 = "(this)";
                    }
                    sb.append(k2);
                    sb.append('=');
                    Object obj2 = objArr[i2];
                    if (obj2 == this) {
                        obj2 = "(this)";
                    }
                    sb.append(obj2);
                }
                i = i2;
            }
            if (z) {
                sb.append('}');
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public a<K, V> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (k3.a) {
                return new a<>(this);
            }
            if (this.h == null) {
                this.h = new a(this);
                this.i = new a(this);
            }
            a aVar = this.h;
            if (!aVar.e) {
                aVar.b();
                a<K, V> aVar2 = this.h;
                aVar2.e = true;
                this.i.e = false;
                return aVar2;
            }
            this.i.b();
            a<K, V> aVar3 = this.i;
            aVar3.e = true;
            this.h.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public c<K> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (k3.a) {
                return new c<>(this);
            }
            if (this.l == null) {
                this.l = new c(this);
                this.m = new c(this);
            }
            c cVar = this.l;
            if (!cVar.e) {
                cVar.b();
                c<K> cVar2 = this.l;
                cVar2.e = true;
                this.m.e = false;
                return cVar2;
            }
            this.m.b();
            c<K> cVar3 = this.m;
            cVar3.e = true;
            this.l.e = false;
            return cVar3;
        }
        return (c) invokeV.objValue;
    }

    public e<V> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (k3.a) {
                return new e<>(this);
            }
            if (this.j == null) {
                this.j = new e(this);
                this.k = new e(this);
            }
            e eVar = this.j;
            if (!eVar.e) {
                eVar.b();
                e<V> eVar2 = this.j;
                eVar2.e = true;
                this.k.e = false;
                return eVar2;
            }
            this.k.b();
            e<V> eVar3 = this.k;
            eVar3.e = true;
            this.j.e = false;
            return eVar3;
        }
        return (e) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T extends K */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends K> V b(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            int f = f(t);
            if (f < 0) {
                return null;
            }
            return this.c[f];
        }
        return (V) invokeL.objValue;
    }

    public int g(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) {
            return (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f);
        }
        return invokeL.intValue;
    }

    public V c(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
            int f = f(k);
            if (f >= 0) {
                return this.c[f];
            }
            return v;
        }
        return (V) invokeLL.objValue;
    }

    public final void i(K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, k, v) == null) {
            K[] kArr = this.b;
            int g = g(k);
            while (kArr[g] != null) {
                g = (g + 1) & this.g;
            }
            kArr[g] = k;
            this.c[g] = v;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: com.baidu.tieba.q3 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof q3)) {
                return false;
            }
            q3 q3Var = (q3) obj;
            if (q3Var.a != this.a) {
                return false;
            }
            K[] kArr = this.b;
            V[] vArr = this.c;
            int length = kArr.length;
            for (int i = 0; i < length; i++) {
                K k = kArr[i];
                if (k != null) {
                    V v = vArr[i];
                    if (v == null) {
                        if (q3Var.c(k, n) != null) {
                            return false;
                        }
                    } else if (!v.equals(q3Var.b(k))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public V j(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, k)) == null) {
            int f = f(k);
            if (f < 0) {
                return null;
            }
            K[] kArr = this.b;
            V[] vArr = this.c;
            V v = vArr[f];
            int i = this.g;
            int i2 = f + 1;
            while (true) {
                int i3 = i2 & i;
                K k2 = kArr[i3];
                if (k2 != null) {
                    int g = g(k2);
                    if (((i3 - g) & i) > ((f - g) & i)) {
                        kArr[f] = k2;
                        vArr[f] = vArr[i3];
                        f = i3;
                    }
                    i2 = i3 + 1;
                } else {
                    kArr[f] = null;
                    vArr[f] = null;
                    this.a--;
                    return v;
                }
            }
        } else {
            return (V) invokeL.objValue;
        }
    }

    public int f(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
            if (k != null) {
                K[] kArr = this.b;
                int g = g(k);
                while (true) {
                    K k2 = kArr[g];
                    if (k2 == null) {
                        return -(g + 1);
                    }
                    if (k2.equals(k)) {
                        return g;
                    }
                    g = (g + 1) & this.g;
                }
            } else {
                throw new IllegalArgumentException("key cannot be null.");
            }
        } else {
            return invokeL.intValue;
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            int length = this.b.length;
            this.e = (int) (i * this.d);
            int i2 = i - 1;
            this.g = i2;
            this.f = Long.numberOfLeadingZeros(i2);
            K[] kArr = this.b;
            V[] vArr = this.c;
            this.b = (K[]) new Object[i];
            this.c = (V[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    K k = kArr[i3];
                    if (k != null) {
                        i(k, vArr[i3]);
                    }
                }
            }
        }
    }

    public V h(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, v)) == null) {
            int f = f(k);
            if (f >= 0) {
                V[] vArr = this.c;
                V v2 = vArr[f];
                vArr[f] = v;
                return v2;
            }
            int i = -(f + 1);
            K[] kArr = this.b;
            kArr[i] = k;
            this.c[i] = v;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.e) {
                k(kArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }
}
