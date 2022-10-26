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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class x7 implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Object[] b;
    public Object[] c;
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

    /* loaded from: classes6.dex */
    public class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b f;

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x7 x7Var) {
            super(x7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((x7) newInitContext.callArgs[0]);
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
                        x7 x7Var = this.b;
                        Object[] objArr = x7Var.b;
                        b bVar = this.f;
                        int i = this.c;
                        bVar.a = objArr[i];
                        bVar.b = x7Var.c[i];
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

    /* loaded from: classes6.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (c) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x7 x7Var) {
            super(x7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((x7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public b7 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return e(new b7(true, this.b.a));
            }
            return (b7) invokeV.objValue;
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
            c();
            return this;
        }

        public b7 e(b7 b7Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b7Var)) == null) {
                while (this.a) {
                    b7Var.a(next());
                }
                return b7Var;
            }
            return (b7) invokeL.objValue;
        }

        @Override // java.util.Iterator
        public Object next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        Object[] objArr = this.b.b;
                        int i = this.c;
                        Object obj = objArr[i];
                        this.d = i;
                        a();
                        return obj;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class d implements Iterable, Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final x7 b;
        public int c;
        public int d;
        public boolean e;

        public d(x7 x7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x7Var};
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
            this.b = x7Var;
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

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.d;
                if (i >= 0) {
                    x7 x7Var = this.b;
                    Object[] objArr = x7Var.b;
                    Object[] objArr2 = x7Var.c;
                    int i2 = x7Var.g;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        Object obj = objArr[i4];
                        if (obj == null) {
                            break;
                        }
                        int h = this.b.h(obj);
                        if (((i4 - h) & i2) > ((i - h) & i2)) {
                            objArr[i] = obj;
                            objArr2[i] = objArr2[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    objArr[i] = null;
                    objArr2[i] = null;
                    x7 x7Var2 = this.b;
                    x7Var2.a--;
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

    /* loaded from: classes6.dex */
    public class e extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (e) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(x7 x7Var) {
            super(x7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((x7) newInitContext.callArgs[0]);
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
        public Object next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a) {
                    if (this.e) {
                        Object[] objArr = this.b.c;
                        int i = this.c;
                        Object obj = objArr[i];
                        this.d = i;
                        a();
                        return obj;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320206, "Lcom/baidu/tieba/x7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320206, "Lcom/baidu/tieba/x7;");
                return;
            }
        }
        n = new Object();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a == 0) {
            return;
        }
        this.a = 0;
        Arrays.fill(this.b, (Object) null);
        Arrays.fill(this.c, (Object) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: e */
    public a iterator() {
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
            Object[] objArr = this.b;
            Object[] objArr2 = this.c;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = objArr[i2];
                if (obj != null) {
                    i += obj.hashCode();
                    Object obj2 = objArr2[i2];
                    if (obj2 != null) {
                        i += obj2.hashCode();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return m(StringUtil.ARRAY_ELEMENT_SEPARATOR, true);
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x7() {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x7(int i) {
        this(i, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof x7)) {
                return false;
            }
            x7 x7Var = (x7) obj;
            if (x7Var.a != this.a) {
                return false;
            }
            Object[] objArr = this.b;
            Object[] objArr2 = this.c;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj2 = objArr[i];
                if (obj2 != null) {
                    Object obj3 = objArr2[i];
                    if (obj3 == null) {
                        if (x7Var.d(obj2, n) != null) {
                            return false;
                        }
                    } else if (!obj3.equals(x7Var.c(obj2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Object k(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            int g = g(obj);
            if (g < 0) {
                return null;
            }
            Object[] objArr = this.b;
            Object[] objArr2 = this.c;
            Object obj2 = objArr2[g];
            int i = this.g;
            int i2 = g + 1;
            while (true) {
                int i3 = i2 & i;
                Object obj3 = objArr[i3];
                if (obj3 != null) {
                    int h = h(obj3);
                    if (((i3 - h) & i) > ((g - h) & i)) {
                        objArr[g] = obj3;
                        objArr2[g] = objArr2[i3];
                        g = i3;
                    }
                    i2 = i3 + 1;
                } else {
                    objArr[g] = null;
                    objArr2[g] = null;
                    this.a--;
                    return obj2;
                }
            }
        } else {
            return invokeL.objValue;
        }
    }

    public x7(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
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
            this.c = new Object[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public String m(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
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
            Object[] objArr2 = this.c;
            int length = objArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                Object obj = objArr[i];
                if (obj == null) {
                    length = i;
                } else {
                    if (obj == this) {
                        obj = "(this)";
                    }
                    sb.append(obj);
                    sb.append('=');
                    Object obj2 = objArr2[i];
                    if (obj2 == this) {
                        obj2 = "(this)";
                    }
                    sb.append(obj2);
                }
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                Object obj3 = objArr[i2];
                if (obj3 != null) {
                    sb.append(str);
                    if (obj3 == this) {
                        obj3 = "(this)";
                    }
                    sb.append(obj3);
                    sb.append('=');
                    Object obj4 = objArr2[i2];
                    if (obj4 == this) {
                        obj4 = "(this)";
                    }
                    sb.append(obj4);
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
            if (g(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Object c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            int g = g(obj);
            if (g < 0) {
                return null;
            }
            return this.c[g];
        }
        return invokeL.objValue;
    }

    public int h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
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

    public c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (g7.a) {
                return new c(this);
            }
            if (this.l == null) {
                this.l = new c(this);
                this.m = new c(this);
            }
            c cVar = this.l;
            if (!cVar.e) {
                cVar.b();
                c cVar2 = this.l;
                cVar2.e = true;
                this.m.e = false;
                return cVar2;
            }
            this.m.b();
            c cVar3 = this.m;
            cVar3.e = true;
            this.l.e = false;
            return cVar3;
        }
        return (c) invokeV.objValue;
    }

    public e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (g7.a) {
                return new e(this);
            }
            if (this.j == null) {
                this.j = new e(this);
                this.k = new e(this);
            }
            e eVar = this.j;
            if (!eVar.e) {
                eVar.b();
                e eVar2 = this.j;
                eVar2.e = true;
                this.k.e = false;
                return eVar2;
            }
            this.k.b();
            e eVar3 = this.k;
            eVar3.e = true;
            this.j.e = false;
            return eVar3;
        }
        return (e) invokeV.objValue;
    }

    public Object d(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, obj, obj2)) == null) {
            int g = g(obj);
            if (g >= 0) {
                return this.c[g];
            }
            return obj2;
        }
        return invokeLL.objValue;
    }

    public final void j(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, obj, obj2) == null) {
            Object[] objArr = this.b;
            int h = h(obj);
            while (objArr[h] != null) {
                h = (h + 1) & this.g;
            }
            objArr[h] = obj;
            this.c[h] = obj2;
        }
    }

    public int g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj != null) {
                Object[] objArr = this.b;
                int h = h(obj);
                while (true) {
                    Object obj2 = objArr[h];
                    if (obj2 == null) {
                        return -(h + 1);
                    }
                    if (obj2.equals(obj)) {
                        return h;
                    }
                    h = (h + 1) & this.g;
                }
            } else {
                throw new IllegalArgumentException("key cannot be null.");
            }
        } else {
            return invokeL.intValue;
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            int length = this.b.length;
            this.e = (int) (i * this.d);
            int i2 = i - 1;
            this.g = i2;
            this.f = Long.numberOfLeadingZeros(i2);
            Object[] objArr = this.b;
            Object[] objArr2 = this.c;
            this.b = new Object[i];
            this.c = new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = objArr[i3];
                    if (obj != null) {
                        j(obj, objArr2[i3]);
                    }
                }
            }
        }
    }

    public Object i(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, obj2)) == null) {
            int g = g(obj);
            if (g >= 0) {
                Object[] objArr = this.c;
                Object obj3 = objArr[g];
                objArr[g] = obj2;
                return obj3;
            }
            int i = -(g + 1);
            Object[] objArr2 = this.b;
            objArr2[i] = obj;
            this.c[i] = obj2;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.e) {
                l(objArr2.length << 1);
                return null;
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
