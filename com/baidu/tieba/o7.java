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
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class o7<K> implements Iterable<b<K>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public K[] b;
    public float[] c;
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
        public float b;

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
                    float[] fArr = o7Var.c;
                    int i2 = o7Var.g;
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
                            fArr[i] = fArr[i4];
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
            int h = r7.h(i, f);
            this.e = (int) (h * f);
            int i4 = h - 1;
            this.g = i4;
            this.f = Long.numberOfLeadingZeros(i4);
            this.b = (K[]) new Object[h];
            this.c = new float[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public final String j(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
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
            float[] fArr = this.c;
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
                        sb.append(fArr[i]);
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
                    sb.append(fArr[i2]);
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
            if (e(k) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
            return (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f);
        }
        return invokeL.intValue;
    }

    public a<K> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (z6.a) {
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

    public float c(K k, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, k, f)) == null) {
            int e = e(k);
            if (e >= 0) {
                return this.c[e];
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    public final void h(K k, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, f) == null) {
            K[] kArr = this.b;
            int f2 = f(k);
            while (kArr[f2] != null) {
                f2 = (f2 + 1) & this.g;
            }
            kArr[f2] = k;
            this.c[f2] = f;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: d */
    public a<K> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b();
        }
        return (a) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.a;
            K[] kArr = this.b;
            float[] fArr = this.c;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    i += k.hashCode() + n7.b(fArr[i2]);
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return j(StringUtil.ARRAY_ELEMENT_SEPARATOR, true);
        }
        return (String) invokeV.objValue;
    }

    public int e(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) {
            if (k != null) {
                K[] kArr = this.b;
                int f = f(k);
                while (true) {
                    K k2 = kArr[f];
                    if (k2 == null) {
                        return -(f + 1);
                    }
                    if (k2.equals(k)) {
                        return f;
                    }
                    f = (f + 1) & this.g;
                }
            } else {
                throw new IllegalArgumentException("key cannot be null.");
            }
        } else {
            return invokeL.intValue;
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            int length = this.b.length;
            this.e = (int) (i * this.d);
            int i2 = i - 1;
            this.g = i2;
            this.f = Long.numberOfLeadingZeros(i2);
            K[] kArr = this.b;
            float[] fArr = this.c;
            this.b = (K[]) new Object[i];
            this.c = new float[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    K k = kArr[i3];
                    if (k != null) {
                        h(k, fArr[i3]);
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
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
            float[] fArr = this.c;
            int length = kArr.length;
            for (int i = 0; i < length; i++) {
                K k = kArr[i];
                if (k != null) {
                    float c2 = o7Var.c(k, 0.0f);
                    if ((c2 == 0.0f && !o7Var.a(k)) || c2 != fArr[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(K k, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048583, this, k, f) == null) {
            int e = e(k);
            if (e >= 0) {
                this.c[e] = f;
                return;
            }
            int i = -(e + 1);
            K[] kArr = this.b;
            kArr[i] = k;
            this.c[i] = f;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.e) {
                i(kArr.length << 1);
            }
        }
    }
}
