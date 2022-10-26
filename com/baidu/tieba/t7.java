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
/* loaded from: classes5.dex */
public class t7 implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long[] b;
    public Object[] c;
    public Object d;
    public boolean e;
    public final float f;
    public int g;
    public int h;
    public int i;
    public transient a j;
    public transient a k;

    /* loaded from: classes5.dex */
    public class a extends c implements Iterable, Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b f;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t7 t7Var) {
            super(t7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: c */
        public b next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        t7 t7Var = this.b;
                        long[] jArr = t7Var.b;
                        int i = this.c;
                        if (i == -1) {
                            b bVar = this.f;
                            bVar.a = 0L;
                            bVar.b = t7Var.d;
                        } else {
                            b bVar2 = this.f;
                            bVar2.a = jArr[i];
                            bVar2.b = t7Var.c[i];
                        }
                        this.d = this.c;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public Object b;

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

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final t7 b;
        public int c;
        public int d;
        public boolean e;

        public c(t7 t7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7Var};
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
            this.b = t7Var;
            b();
        }

        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long[] jArr = this.b.b;
                int length = jArr.length;
                do {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (jArr[i] == 0);
                this.a = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = -2;
                this.c = -1;
                if (this.b.e) {
                    this.a = true;
                } else {
                    a();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i == -1) {
                    t7 t7Var = this.b;
                    if (t7Var.e) {
                        t7Var.e = false;
                        t7Var.d = null;
                        this.d = -2;
                        t7 t7Var2 = this.b;
                        t7Var2.a--;
                        return;
                    }
                }
                if (i >= 0) {
                    t7 t7Var3 = this.b;
                    long[] jArr = t7Var3.b;
                    Object[] objArr = t7Var3.c;
                    int i2 = t7Var3.i;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        long j = jArr[i4];
                        if (j == 0) {
                            break;
                        }
                        int e = this.b.e(j);
                        if (((i4 - e) & i2) > ((i - e) & i2)) {
                            jArr[i] = j;
                            objArr[i] = objArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    jArr[i] = 0;
                    objArr[i] = null;
                    if (i != this.d) {
                        this.c--;
                    }
                    this.d = -2;
                    t7 t7Var22 = this.b;
                    t7Var22.a--;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t7() {
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

    public int hashCode() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.a;
            if (this.e && (obj = this.d) != null) {
                i += obj.hashCode();
            }
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int length = jArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                long j = jArr[i2];
                if (j != 0) {
                    i = (int) (i + (j * 31));
                    Object obj2 = objArr[i2];
                    if (obj2 != null) {
                        i += obj2.hashCode();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public t7(int i, float f) {
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
            this.f = f;
            int h = y7.h(i, f);
            this.g = (int) (h * f);
            int i4 = h - 1;
            this.i = i4;
            this.h = Long.numberOfLeadingZeros(i4);
            this.b = new long[h];
            this.c = new Object[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (g7.a) {
                return new a(this);
            }
            if (this.j == null) {
                this.j = new a(this);
                this.k = new a(this);
            }
            a aVar = this.j;
            if (!aVar.e) {
                aVar.b();
                a aVar2 = this.j;
                aVar2.e = true;
                this.k.e = false;
                return aVar2;
            }
            this.k.b();
            a aVar3 = this.k;
            aVar3.e = true;
            this.j.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public Object b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j == 0) {
                if (!this.e) {
                    return null;
                }
                return this.d;
            }
            int d = d(j);
            if (d < 0) {
                return null;
            }
            return this.c[d];
        }
        return invokeJ.objValue;
    }

    public final int d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            long[] jArr = this.b;
            int e = e(j);
            while (true) {
                long j2 = jArr[e];
                if (j2 == 0) {
                    return -(e + 1);
                }
                if (j2 == j) {
                    return e;
                }
                e = (e + 1) & this.i;
            }
        } else {
            return invokeJ.intValue;
        }
    }

    public int e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            return (int) (((j ^ (j >>> 32)) * (-7046029254386353131L)) >>> this.h);
        }
        return invokeJ.intValue;
    }

    public Object c(long j, Object obj) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, obj)) == null) {
            if (j == 0) {
                if (this.e) {
                    return this.d;
                }
                return obj;
            }
            int d = d(j);
            if (d >= 0) {
                return this.c[d];
            }
            return obj;
        }
        return invokeJL.objValue;
    }

    public final void g(long j, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, obj) == null) {
            long[] jArr = this.b;
            int e = e(j);
            while (jArr[e] != 0) {
                e = (e + 1) & this.i;
            }
            jArr[e] = j;
            this.c[e] = obj;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t7)) {
                return false;
            }
            t7 t7Var = (t7) obj;
            if (t7Var.a != this.a) {
                return false;
            }
            boolean z = t7Var.e;
            boolean z2 = this.e;
            if (z != z2) {
                return false;
            }
            if (z2) {
                Object obj2 = t7Var.d;
                if (obj2 == null) {
                    if (this.d != null) {
                        return false;
                    }
                } else if (!obj2.equals(this.d)) {
                    return false;
                }
            }
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                long j = jArr[i];
                if (j != 0) {
                    Object obj3 = objArr[i];
                    if (obj3 == null) {
                        if (t7Var.c(j, x7.n) != null) {
                            return false;
                        }
                    } else if (!obj3.equals(t7Var.b(j))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Object f(long j, Object obj) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j, obj)) == null) {
            if (j == 0) {
                Object obj2 = this.d;
                this.d = obj;
                if (!this.e) {
                    this.e = true;
                    this.a++;
                }
                return obj2;
            }
            int d = d(j);
            if (d >= 0) {
                Object[] objArr = this.c;
                Object obj3 = objArr[d];
                objArr[d] = obj;
                return obj3;
            }
            int i = -(d + 1);
            long[] jArr = this.b;
            jArr[i] = j;
            this.c[i] = obj;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.g) {
                h(jArr.length << 1);
                return null;
            }
            return null;
        }
        return invokeJL.objValue;
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int length = this.b.length;
            this.g = (int) (i * this.f);
            int i2 = i - 1;
            this.i = i2;
            this.h = Long.numberOfLeadingZeros(i2);
            long[] jArr = this.b;
            Object[] objArr = this.c;
            this.b = new long[i];
            this.c = new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    long j = jArr[i3];
                    if (j != 0) {
                        g(j, objArr[i3]);
                    }
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return a();
        }
        return (Iterator) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0046 -> B:18:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == 0) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder(32);
            sb.append('[');
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int length = jArr.length;
            if (this.e) {
                sb.append("0=");
                sb.append(this.d);
                i = length - 1;
                if (length > 0) {
                    long j = jArr[i];
                    if (j != 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(j);
                        sb.append('=');
                        sb.append(objArr[i]);
                    }
                    length = i;
                    i = length - 1;
                    if (length > 0) {
                        sb.append(']');
                        return sb.toString();
                    }
                }
            } else {
                while (true) {
                    i = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    long j2 = jArr[i];
                    if (j2 == 0) {
                        length = i;
                    } else {
                        sb.append(j2);
                        sb.append('=');
                        sb.append(objArr[i]);
                        break;
                    }
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                }
            }
        } else {
            return (String) invokeV.objValue;
        }
    }
}
