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
public class o7<K> implements Iterable<b<K>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public K[] b;
    public int[] c;
    public float d;
    public int e;
    public int f;
    public int g;
    public transient a h;
    public transient a i;

    /* loaded from: classes7.dex */
    public static class a<K> extends c<K> implements Iterable<b<K>>, Iterator<b<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<K> f;

        public a<K> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o7<K> o7Var) {
            super(o7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o7) newInitContext.callArgs[0]);
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
        public b<K> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        o7<K> o7Var = this.b;
                        K[] kArr = o7Var.b;
                        b<K> bVar = this.f;
                        int i = this.c;
                        bVar.a = kArr[i];
                        bVar.b = o7Var.c[i];
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
    public static class b<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public K a;
        public int b;

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
    public static class c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final o7<K> b;
        public int c;
        public int d;
        public boolean e;

        public c(o7<K> o7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o7Var};
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
            this.b = o7Var;
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

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i >= 0) {
                    o7<K> o7Var = this.b;
                    K[] kArr = o7Var.b;
                    int[] iArr = o7Var.c;
                    int i2 = o7Var.g;
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
                            iArr[i] = iArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    o7<K> o7Var2 = this.b;
                    o7Var2.a--;
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
    public o7() {
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

    public o7(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f > 0.0f && f < 1.0f) {
            this.d = f;
            int h = q7.h(i, f);
            this.e = (int) (h * f);
            int i4 = h - 1;
            this.g = i4;
            this.f = Long.numberOfLeadingZeros(i4);
            this.b = (K[]) new Object[h];
            this.c = new int[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public final String k(String str, boolean z) {
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
            int[] iArr = this.c;
            int length = kArr.length;
            while (true) {
                i = length - 1;
                if (length > 0) {
                    K k = kArr[i];
                    if (k == null) {
                        length = i;
                    } else {
                        sb.append(k);
                        sb.append('=');
                        sb.append(iArr[i]);
                        break;
                    }
                } else {
                    break;
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
                    sb.append(k2);
                    sb.append('=');
                    sb.append(iArr[i2]);
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

    public boolean a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
            if (f(k) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int g(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) {
            return (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f);
        }
        return invokeL.intValue;
    }

    public a<K> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (y6.a) {
                return new a<>(this);
            }
            if (this.h == null) {
                this.h = new a(this);
                this.i = new a(this);
            }
            a aVar = this.h;
            if (!aVar.e) {
                aVar.b();
                a<K> aVar2 = this.h;
                aVar2.e = true;
                this.i.e = false;
                return aVar2;
            }
            this.i.b();
            a<K> aVar3 = this.i;
            aVar3.e = true;
            this.h.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public int c(K k, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, k, i)) == null) {
            int f = f(k);
            if (f >= 0) {
                return this.c[f];
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public final void i(K k, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, k, i) == null) {
            K[] kArr = this.b;
            int g = g(k);
            while (kArr[g] != null) {
                g = (g + 1) & this.g;
            }
            kArr[g] = k;
            this.c[g] = i;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a == 0) {
            return;
        }
        this.a = 0;
        Arrays.fill(this.b, (Object) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: e */
    public a<K> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return b();
        }
        return (a) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.a;
            K[] kArr = this.b;
            int[] iArr = this.c;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    i += k.hashCode() + iArr[i2];
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
            return k(StringUtil.ARRAY_ELEMENT_SEPARATOR, true);
        }
        return (String) invokeV.objValue;
    }

    public int d(K k, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, k, i, i2)) == null) {
            int f = f(k);
            if (f >= 0) {
                int[] iArr = this.c;
                int i3 = iArr[f];
                iArr[f] = iArr[f] + i2;
                return i3;
            }
            int i4 = -(f + 1);
            K[] kArr = this.b;
            kArr[i4] = k;
            this.c[i4] = i2 + i;
            int i5 = this.a + 1;
            this.a = i5;
            if (i5 >= this.e) {
                j(kArr.length << 1);
            }
            return i;
        }
        return invokeLII.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof o7)) {
                return false;
            }
            o7 o7Var = (o7) obj;
            if (o7Var.a != this.a) {
                return false;
            }
            K[] kArr = this.b;
            int[] iArr = this.c;
            int length = kArr.length;
            for (int i = 0; i < length; i++) {
                K k = kArr[i];
                if (k != null && (((c2 = o7Var.c(k, 0)) == 0 && !o7Var.a(k)) || c2 != iArr[i])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int f(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) {
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

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            int length = this.b.length;
            this.e = (int) (i * this.d);
            int i2 = i - 1;
            this.g = i2;
            this.f = Long.numberOfLeadingZeros(i2);
            K[] kArr = this.b;
            int[] iArr = this.c;
            this.b = (K[]) new Object[i];
            this.c = new int[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    K k = kArr[i3];
                    if (k != null) {
                        i(k, iArr[i3]);
                    }
                }
            }
        }
    }

    public void h(K k, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, k, i) == null) {
            int f = f(k);
            if (f >= 0) {
                this.c[f] = i;
                return;
            }
            int i2 = -(f + 1);
            K[] kArr = this.b;
            kArr[i2] = k;
            this.c[i2] = i;
            int i3 = this.a + 1;
            this.a = i3;
            if (i3 >= this.e) {
                j(kArr.length << 1);
            }
        }
    }
}
