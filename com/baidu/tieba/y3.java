package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class y3 implements Iterable<x3>, Comparator<x3>, Comparable<y3> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final u6<x3> b;
    public boolean c;

    public y3() {
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
        this.b = new u6<>();
        this.c = true;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return a();
        }
        return invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !this.c) {
            this.b.sort(this);
            this.c = true;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<x3> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i();
            int i = this.b.b;
            long j = this.a + 71;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 7) & 65535;
                j += this.a * this.b.get(i3).hashCode() * i2;
            }
            return (int) (j ^ (j >> 32));
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: b */
    public final int compare(x3 x3Var, x3 x3Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x3Var, x3Var2)) == null) {
            return (int) (x3Var.a - x3Var2.a);
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(y3 y3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y3Var)) == null) {
            if (y3Var == this) {
                return 0;
            }
            long j = this.a;
            long j2 = y3Var.a;
            if (j != j2) {
                if (j < j2) {
                    return -1;
                }
                return 1;
            }
            i();
            y3Var.i();
            int i = 0;
            while (true) {
                u6<x3> u6Var = this.b;
                if (i >= u6Var.b) {
                    return 0;
                }
                int compareTo = u6Var.get(i).compareTo(y3Var.b.get(i));
                if (compareTo != 0) {
                    if (compareTo < 0) {
                        return -1;
                    }
                    if (compareTo <= 0) {
                        return 0;
                    }
                    return 1;
                }
                i++;
            }
        } else {
            return invokeL.intValue;
        }
    }

    public final void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.a = j | this.a;
        }
    }

    public final boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (j != 0 && (this.a & j) == j) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (!(obj instanceof y3)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return g((y3) obj, true);
        }
        return invokeL.booleanValue;
    }

    public int f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            if (e(j)) {
                int i = 0;
                while (true) {
                    u6<x3> u6Var = this.b;
                    if (i < u6Var.b) {
                        if (u6Var.get(i).a == j) {
                            return i;
                        }
                        i++;
                    } else {
                        return -1;
                    }
                }
            } else {
                return -1;
            }
        } else {
            return invokeJ.intValue;
        }
    }

    public final void h(x3 x3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, x3Var) == null) {
            int f = f(x3Var.a);
            if (f < 0) {
                d(x3Var.a);
                this.b.a(x3Var);
                this.c = false;
            } else {
                this.b.k(f, x3Var);
            }
            i();
        }
    }

    public final boolean g(y3 y3Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, y3Var, z)) == null) {
            if (y3Var == this) {
                return true;
            }
            if (y3Var == null || this.a != y3Var.a) {
                return false;
            }
            if (!z) {
                return true;
            }
            i();
            y3Var.i();
            int i = 0;
            while (true) {
                u6<x3> u6Var = this.b;
                if (i >= u6Var.b) {
                    return true;
                }
                if (!u6Var.get(i).a(y3Var.b.get(i))) {
                    return false;
                }
                i++;
            }
        } else {
            return invokeLZ.booleanValue;
        }
    }
}
