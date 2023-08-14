package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class l3c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;
    public int b;
    public int c;
    public int d;
    public T[] e;

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = i * (-1640531527);
            return i2 ^ (i2 >>> 16);
        }
        return invokeI.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l3c() {
        this(16, 0.75f);
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

    public l3c(int i, float f) {
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
        this.a = f;
        int b = e4c.b(i);
        this.b = b - 1;
        this.d = (int) (f * b);
        this.e = (T[]) new Object[b];
    }

    public boolean a(T t) {
        InterceptResult invokeL;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            T[] tArr = this.e;
            int i = this.b;
            int c = c(t.hashCode()) & i;
            T t3 = tArr[c];
            if (t3 != null) {
                if (t3.equals(t)) {
                    return false;
                }
                do {
                    c = (c + 1) & i;
                    t2 = tArr[c];
                    if (t2 == null) {
                    }
                } while (!t2.equals(t));
                return false;
            }
            tArr[c] = t;
            int i2 = this.c + 1;
            this.c = i2;
            if (i2 >= this.d) {
                d();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = 0;
            this.e = (T[]) new Object[0];
        }
    }

    public T[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (T[]) ((Object[]) invokeV.objValue);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            T[] tArr = this.e;
            int length = tArr.length;
            int i = length << 1;
            int i2 = i - 1;
            T[] tArr2 = (T[]) new Object[i];
            int i3 = this.c;
            while (true) {
                int i4 = i3 - 1;
                if (i3 != 0) {
                    do {
                        length--;
                    } while (tArr[length] == null);
                    int c = c(tArr[length].hashCode()) & i2;
                    if (tArr2[c] != null) {
                        do {
                            c = (c + 1) & i2;
                        } while (tArr2[c] != null);
                    }
                    tArr2[c] = tArr[length];
                    i3 = i4;
                } else {
                    this.b = i2;
                    this.d = (int) (i * this.a);
                    this.e = tArr2;
                    return;
                }
            }
        }
    }

    public boolean e(T t) {
        InterceptResult invokeL;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
            T[] tArr = this.e;
            int i = this.b;
            int c = c(t.hashCode()) & i;
            T t3 = tArr[c];
            if (t3 == null) {
                return false;
            }
            if (t3.equals(t)) {
                return f(c, tArr, i);
            }
            do {
                c = (c + 1) & i;
                t2 = tArr[c];
                if (t2 == null) {
                    return false;
                }
            } while (!t2.equals(t));
            return f(c, tArr, i);
        }
        return invokeL.booleanValue;
    }

    public boolean f(int i, T[] tArr, int i2) {
        InterceptResult invokeCommon;
        int i3;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), tArr, Integer.valueOf(i2)})) == null) {
            this.c--;
            while (true) {
                int i4 = i + 1;
                while (true) {
                    i3 = i4 & i2;
                    t = tArr[i3];
                    if (t == null) {
                        tArr[i] = null;
                        return true;
                    }
                    int c = c(t.hashCode()) & i2;
                    if (i <= i3) {
                        if (i < c && c <= i3) {
                            i4 = i3 + 1;
                        }
                    } else {
                        if (i >= c && c > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                }
                tArr[i] = t;
                i = i3;
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }
}
