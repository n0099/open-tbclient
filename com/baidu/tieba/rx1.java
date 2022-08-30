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
public class rx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948136894, "Lcom/baidu/tieba/rx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948136894, "Lcom/baidu/tieba/rx1;");
                return;
            }
        }
        b = kh1.a;
        c = 5;
    }

    public rx1(@IntRange(from = 1) int i) {
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

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i >> c : invokeI.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean b(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                ay1.c("Component-DiffBitMap", "diff < 0: " + i);
                if (b) {
                    throw new IndexOutOfBoundsException("diff < 0: " + i);
                }
                return false;
            }
            int[] iArr = this.a;
            int length = (iArr.length << c) - 1;
            if (i <= length) {
                return ((1 << i) & iArr[a(i)]) != 0;
            }
            String str = "diff > " + length + ": " + i;
            ay1.c("Component-DiffBitMap", str);
            if (b) {
                throw new IndexOutOfBoundsException(str);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void c(@IntRange(from = 1) int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i <= 0) {
                String str = "number <= 0: " + i;
                ay1.c("Component-DiffBitMap", str);
                if (b) {
                    throw new NegativeArraySizeException(str);
                }
                i = 500;
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

    @SuppressLint({"BDThrowableCheck"})
    public void d(@IntRange(from = 0) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i < 0) {
                ay1.c("Component-DiffBitMap", "diff < 0: " + i);
                if (b) {
                    throw new IndexOutOfBoundsException("diff < 0: " + i);
                }
                return;
            }
            int[] iArr = this.a;
            int length = (iArr.length << c) - 1;
            if (i > length) {
                String str = "diff > " + length + ": " + i;
                ay1.c("Component-DiffBitMap", str);
                if (b) {
                    throw new IndexOutOfBoundsException(str);
                }
                return;
            }
            int a = a(i);
            iArr[a] = (1 << i) | iArr[a];
        }
    }

    public rx1(@IntRange(from = 1) int i, boolean z) {
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
}
