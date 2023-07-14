package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z18 {
    public static /* synthetic */ Interceptable $ic;
    public static z18 f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public SparseArray<Long> b;
    public SparseArray<Long> c;
    public SparseArray<Long> d;
    public SparseArray<Long> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307208, "Lcom/baidu/tieba/z18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307208, "Lcom/baidu/tieba/z18;");
                return;
            }
        }
        f = new z18();
    }

    public static z18 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (z18) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public z18() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.d = new SparseArray<>();
        this.e = new SparseArray<>();
    }

    public long a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Long l = this.c.get(i);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Long l = this.b.get(i);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Long l = this.e.get(i);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Long l = this.d.get(i);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.a = j;
        }
    }

    public void g(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.c.put(i, Long.valueOf(j));
        }
    }

    public void i(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.b.put(i, Long.valueOf(j));
        }
    }

    public void j(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.e.put(i, Long.valueOf(j));
        }
    }

    public void k(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.d.put(i, Long.valueOf(j));
        }
    }
}
