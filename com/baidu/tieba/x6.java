package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class x6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] a;

    public x6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new long[]{0};
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Arrays.fill(this.a, 0L);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long[] jArr = this.a;
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                if (jArr[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int h = h() >>> 6;
            int i = 0;
            for (int i2 = 0; h >= i2; i2++) {
                long[] jArr = this.a;
                i = (i * 127) + ((int) (jArr[i2] ^ (jArr[i2] >>> 32)));
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            long[] jArr = this.a;
            if (i >= jArr.length) {
                long[] jArr2 = new long[i + 1];
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                this.a = jArr2;
            }
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int i2 = i >>> 6;
            long[] jArr = this.a;
            if (i2 >= jArr.length) {
                return;
            }
            jArr[i2] = jArr[i2] & (~(1 << (i & 63)));
        }
    }

    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int i2 = i >>> 6;
            long[] jArr = this.a;
            if (i2 >= jArr.length || (jArr[i2] & (1 << (i & 63))) == 0) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean f(x6 x6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, x6Var)) == null) {
            long[] jArr = this.a;
            long[] jArr2 = x6Var.a;
            for (int min = Math.min(jArr.length, jArr2.length) - 1; min >= 0; min--) {
                if ((jArr[min] & jArr2[min]) != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            int i2 = i >>> 6;
            a(i2);
            long[] jArr = this.a;
            jArr[i2] = jArr[i2] | (1 << (i & 63));
        }
    }

    public boolean d(x6 x6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, x6Var)) == null) {
            long[] jArr = this.a;
            long[] jArr2 = x6Var.a;
            int length = jArr2.length;
            int length2 = jArr.length;
            for (int i = length2; i < length; i++) {
                if (jArr2[i] != 0) {
                    return false;
                }
            }
            for (int min = Math.min(length2, length) - 1; min >= 0; min--) {
                if ((jArr[min] & jArr2[min]) != jArr2[min]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j(x6 x6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, x6Var) == null) {
            int min = Math.min(this.a.length, x6Var.a.length);
            for (int i = 0; min > i; i++) {
                long[] jArr = this.a;
                jArr[i] = jArr[i] | x6Var.a[i];
            }
            long[] jArr2 = x6Var.a;
            if (min < jArr2.length) {
                a(jArr2.length);
                int length = x6Var.a.length;
                while (length > min) {
                    this.a[min] = x6Var.a[min];
                    min++;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || x6.class != obj.getClass()) {
                return false;
            }
            x6 x6Var = (x6) obj;
            long[] jArr = x6Var.a;
            int min = Math.min(this.a.length, jArr.length);
            for (int i = 0; min > i; i++) {
                if (this.a[i] != jArr[i]) {
                    return false;
                }
            }
            if (this.a.length == jArr.length || h() == x6Var.h()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        return (r1 << 6) + r15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            long[] jArr = this.a;
            int i3 = i >>> 6;
            int length = jArr.length;
            if (i3 >= length) {
                return -1;
            }
            long j = jArr[i3];
            if (j != 0) {
                i2 = i & 63;
                while (i2 < 64) {
                    if (((1 << (i2 & 63)) & j) != 0) {
                        break;
                    }
                    i2++;
                }
            }
            loop1: while (true) {
                i3++;
                if (i3 >= length) {
                    return -1;
                }
                if (i3 != 0) {
                    long j2 = jArr[i3];
                    if (j2 != 0) {
                        i2 = 0;
                        while (i2 < 64) {
                            if (((1 << (i2 & 63)) & j2) != 0) {
                                break loop1;
                            }
                            i2++;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        } else {
            return invokeI.intValue;
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long[] jArr = this.a;
            for (int length = jArr.length - 1; length >= 0; length--) {
                long j = jArr[length];
                if (j != 0) {
                    for (int i = 63; i >= 0; i--) {
                        if (((1 << (i & 63)) & j) != 0) {
                            return (length << 6) + i + 1;
                        }
                    }
                    continue;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
