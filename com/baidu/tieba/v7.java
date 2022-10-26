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
/* loaded from: classes6.dex */
public class v7 implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Object[] b;
    public float[] c;
    public float d;
    public int e;
    public int f;
    public int g;
    public transient a h;
    public transient a i;

    /* loaded from: classes6.dex */
    public class a extends c implements Iterable, Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b f;

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v7 v7Var) {
            super(v7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((v7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        v7 v7Var = this.b;
                        Object[] objArr = v7Var.b;
                        b bVar = this.f;
                        int i = this.c;
                        bVar.a = objArr[i];
                        bVar.b = v7Var.c[i];
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

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
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

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final v7 b;
        public int c;
        public int d;
        public boolean e;

        public c(v7 v7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v7Var};
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
            this.b = v7Var;
            b();
        }

        public void a() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Object[] objArr = this.b.b;
                int length = objArr.length;
                do {
                    i = this.c + 1;
                    this.c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (objArr[i] == null);
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
                    v7 v7Var = this.b;
                    Object[] objArr = v7Var.b;
                    float[] fArr = v7Var.c;
                    int i2 = v7Var.g;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        Object obj = objArr[i4];
                        if (obj == null) {
                            break;
                        }
                        int f = this.b.f(obj);
                        if (((i4 - f) & i2) > ((i - f) & i2)) {
                            objArr[i] = obj;
                            fArr[i] = fArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    objArr[i] = null;
                    v7 v7Var2 = this.b;
                    v7Var2.a--;
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
    public v7() {
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

    public v7(int i, float f) {
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
            int h = y7.h(i, f);
            this.e = (int) (h * f);
            int i4 = h - 1;
            this.g = i4;
            this.f = Long.numberOfLeadingZeros(i4);
            this.b = new Object[h];
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
                    return StringUtil.EMPTY_ARRAY;
                }
                return "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            Object[] objArr = this.b;
            float[] fArr = this.c;
            int length = objArr.length;
            while (true) {
                i = length - 1;
                if (length > 0) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        length = i;
                    } else {
                        sb.append(obj);
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
                Object obj2 = objArr[i2];
                if (obj2 != null) {
                    sb.append(str);
                    sb.append(obj2);
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

    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (e(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            return (int) ((obj.hashCode() * (-7046029254386353131L)) >>> this.f);
        }
        return invokeL.intValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (g7.a) {
                return new a(this);
            }
            if (this.h == null) {
                this.h = new a(this);
                this.i = new a(this);
            }
            a aVar = this.h;
            if (!aVar.e) {
                aVar.b();
                a aVar2 = this.h;
                aVar2.e = true;
                this.i.e = false;
                return aVar2;
            }
            this.i.b();
            a aVar3 = this.i;
            aVar3.e = true;
            this.h.e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public float c(Object obj, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, obj, f)) == null) {
            int e = e(obj);
            if (e >= 0) {
                return this.c[e];
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    public final void h(Object obj, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, f) == null) {
            Object[] objArr = this.b;
            int f2 = f(obj);
            while (objArr[f2] != null) {
                f2 = (f2 + 1) & this.g;
            }
            objArr[f2] = obj;
            this.c[f2] = f;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: d */
    public a iterator() {
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
            Object[] objArr = this.b;
            float[] fArr = this.c;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = objArr[i2];
                if (obj != null) {
                    i += obj.hashCode() + u7.b(fArr[i2]);
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

    public int e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj != null) {
                Object[] objArr = this.b;
                int f = f(obj);
                while (true) {
                    Object obj2 = objArr[f];
                    if (obj2 == null) {
                        return -(f + 1);
                    }
                    if (obj2.equals(obj)) {
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
            Object[] objArr = this.b;
            float[] fArr = this.c;
            this.b = new Object[i];
            this.c = new float[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = objArr[i3];
                    if (obj != null) {
                        h(obj, fArr[i3]);
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
            if (!(obj instanceof v7)) {
                return false;
            }
            v7 v7Var = (v7) obj;
            if (v7Var.a != this.a) {
                return false;
            }
            Object[] objArr = this.b;
            float[] fArr = this.c;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj2 = objArr[i];
                if (obj2 != null) {
                    float c2 = v7Var.c(obj2, 0.0f);
                    if ((c2 == 0.0f && !v7Var.a(obj2)) || c2 != fArr[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(Object obj, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048583, this, obj, f) == null) {
            int e = e(obj);
            if (e >= 0) {
                this.c[e] = f;
                return;
            }
            int i = -(e + 1);
            Object[] objArr = this.b;
            objArr[i] = obj;
            this.c[i] = f;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.e) {
                i(objArr.length << 1);
            }
        }
    }
}
