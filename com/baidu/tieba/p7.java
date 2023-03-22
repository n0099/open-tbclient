package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public short[] a;
    public int b;
    public boolean c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p7() {
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

    public p7(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = new short[i];
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Short.valueOf(s)}) == null) {
            short[] sArr = this.a;
            int i = this.b;
            if (i == sArr.length) {
                sArr = e(Math.max(8, (int) (i * 1.75f)));
            }
            int i2 = this.b;
            this.b = i2 + 1;
            sArr[i2] = s;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!this.c || !(obj instanceof p7)) {
                return false;
            }
            p7 p7Var = (p7) obj;
            if (!p7Var.c || (i = this.b) != p7Var.b) {
                return false;
            }
            short[] sArr = this.a;
            short[] sArr2 = p7Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                if (sArr[i2] != sArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = 0;
        }
    }

    public short[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.b;
            short[] sArr = new short[i];
            System.arraycopy(this.a, 0, sArr, 0, i);
            return sArr;
        }
        return (short[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.c) {
                return super.hashCode();
            }
            short[] sArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + sArr[i3];
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public short[] c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i >= 0) {
                int i2 = this.b + i;
                if (i2 > this.a.length) {
                    e(Math.max(Math.max(8, i2), (int) (this.b * 1.75f)));
                }
                return this.a;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        return (short[]) invokeI.objValue;
    }

    public short d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int i2 = this.b;
            if (i < i2) {
                short[] sArr = this.a;
                short s = sArr[i];
                int i3 = i2 - 1;
                this.b = i3;
                if (this.c) {
                    System.arraycopy(sArr, i + 1, sArr, i, i3 - i);
                } else {
                    sArr[i] = sArr[i3];
                }
                return s;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return invokeI.shortValue;
    }

    public short[] e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            short[] sArr = new short[i];
            System.arraycopy(this.a, 0, sArr, 0, Math.min(this.b, i));
            this.a = sArr;
            return sArr;
        }
        return (short[]) invokeI.objValue;
    }

    public void insert(int i, short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Short.valueOf(s)}) == null) {
            int i2 = this.b;
            if (i <= i2) {
                short[] sArr = this.a;
                if (i2 == sArr.length) {
                    sArr = e(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.c) {
                    System.arraycopy(sArr, i, sArr, i + 1, this.b - i);
                } else {
                    sArr[this.b] = sArr[i];
                }
                this.b++;
                sArr[i] = s;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.b == 0) {
                return "[]";
            }
            short[] sArr = this.a;
            t7 t7Var = new t7(32);
            t7Var.a('[');
            t7Var.d(sArr[0]);
            for (int i = 1; i < this.b; i++) {
                t7Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                t7Var.d(sArr[i]);
            }
            t7Var.a(']');
            return t7Var.toString();
        }
        return (String) invokeV.objValue;
    }
}
