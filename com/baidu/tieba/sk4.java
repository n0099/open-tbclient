package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sk4<E> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Object e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int[] b;
    public Object[] c;
    public int d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948154285, "Lcom/baidu/tieba/sk4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948154285, "Lcom/baidu/tieba/sk4;");
                return;
            }
        }
        e = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sk4() {
        this(10);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.d;
            Object[] objArr = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            this.d = 0;
            this.a = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public sk4<E> clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sk4<E> sk4Var = null;
            try {
                sk4<E> sk4Var2 = (sk4) super.clone();
                try {
                    sk4Var2.b = (int[]) this.b.clone();
                    sk4Var2.c = (Object[]) this.c.clone();
                    return sk4Var2;
                } catch (CloneNotSupportedException unused) {
                    sk4Var = sk4Var2;
                    return sk4Var;
                }
            } catch (CloneNotSupportedException unused2) {
            }
        } else {
            return (sk4) invokeV.objValue;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a) {
                c();
            }
            return this.d;
        }
        return invokeV.intValue;
    }

    public sk4(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = false;
        if (i == 0) {
            this.b = nk4.a;
            this.c = nk4.b;
        } else {
            int d = nk4.d(i);
            this.b = new int[d];
            this.c = new Object[d];
        }
        this.d = 0;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.d;
            int[] iArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != e) {
                    if (i3 != i2) {
                        iArr[i2] = iArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
    }

    public int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.a) {
                c();
            }
            return this.b[i];
        }
        return invokeI.intValue;
    }

    public E f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a) {
                c();
            }
            return (E) this.c[i];
        }
        return (E) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (e() <= 0) {
                return "{}";
            }
            StringBuilder sb = new StringBuilder(this.d * 28);
            sb.append('{');
            for (int i = 0; i < this.d; i++) {
                if (i > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(d(i));
                sb.append('=');
                E f = f(i);
                if (f != this) {
                    sb.append(f);
                } else {
                    sb.append("(this Map)");
                }
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
