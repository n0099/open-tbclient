package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class l42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892831, "Lcom/baidu/tieba/l42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892831, "Lcom/baidu/tieba/l42;");
                return;
            }
        }
        b = eo1.a;
        c = 5;
    }

    public l42(@IntRange(from = 1) int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c(i, false);
    }

    public l42(@IntRange(from = 1) int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c(i, z);
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return i >> c;
        }
        return invokeI.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean b(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                u42.c("Component-DiffBitMap", "diff < 0: " + i);
                if (!b) {
                    return false;
                }
                throw new IndexOutOfBoundsException("diff < 0: " + i);
            }
            int[] iArr = this.a;
            int length = (iArr.length << c) - 1;
            if (i > length) {
                String str = "diff > " + length + ": " + i;
                u42.c("Component-DiffBitMap", str);
                if (!b) {
                    return false;
                }
                throw new IndexOutOfBoundsException(str);
            } else if (((1 << i) & iArr[a(i)]) == 0) {
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void d(@IntRange(from = 0) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i < 0) {
                u42.c("Component-DiffBitMap", "diff < 0: " + i);
                if (!b) {
                    return;
                }
                throw new IndexOutOfBoundsException("diff < 0: " + i);
            }
            int[] iArr = this.a;
            int length = (iArr.length << c) - 1;
            if (i > length) {
                String str = "diff > " + length + ": " + i;
                u42.c("Component-DiffBitMap", str);
                if (!b) {
                    return;
                }
                throw new IndexOutOfBoundsException(str);
            }
            int a = a(i);
            iArr[a] = (1 << i) | iArr[a];
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void c(@IntRange(from = 1) int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i <= 0) {
                String str = "number <= 0: " + i;
                u42.c("Component-DiffBitMap", str);
                if (!b) {
                    i = 500;
                } else {
                    throw new NegativeArraySizeException(str);
                }
            }
            int[] iArr = new int[a(i - 1) + 1];
            this.a = iArr;
            int length = iArr.length;
            if (z) {
                for (int i2 = 0; i2 < length; i2++) {
                    this.a[i2] = -1;
                }
            }
        }
    }
}
