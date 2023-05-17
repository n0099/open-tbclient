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
/* loaded from: classes7.dex */
public class s3 implements Iterable<r3>, Comparator<r3>, Comparable<s3> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final o6<r3> b;
    public boolean c;

    public s3() {
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
        this.b = new o6<>();
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
    public final Iterator<r3> iterator() {
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
    public final int compare(r3 r3Var, r3 r3Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r3Var, r3Var2)) == null) {
            return (int) (r3Var.a - r3Var2.a);
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(s3 s3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s3Var)) == null) {
            if (s3Var == this) {
                return 0;
            }
            long j = this.a;
            long j2 = s3Var.a;
            if (j != j2) {
                if (j < j2) {
                    return -1;
                }
                return 1;
            }
            i();
            s3Var.i();
            int i = 0;
            while (true) {
                o6<r3> o6Var = this.b;
                if (i >= o6Var.b) {
                    return 0;
                }
                int compareTo = o6Var.get(i).compareTo(s3Var.b.get(i));
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
            if (!(obj instanceof s3)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return g((s3) obj, true);
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
                    o6<r3> o6Var = this.b;
                    if (i < o6Var.b) {
                        if (o6Var.get(i).a == j) {
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

    public final void h(r3 r3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, r3Var) == null) {
            int f = f(r3Var.a);
            if (f < 0) {
                d(r3Var.a);
                this.b.a(r3Var);
                this.c = false;
            } else {
                this.b.k(f, r3Var);
            }
            i();
        }
    }

    public final boolean g(s3 s3Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, s3Var, z)) == null) {
            if (s3Var == this) {
                return true;
            }
            if (s3Var == null || this.a != s3Var.a) {
                return false;
            }
            if (!z) {
                return true;
            }
            i();
            s3Var.i();
            int i = 0;
            while (true) {
                o6<r3> o6Var = this.b;
                if (i >= o6Var.b) {
                    return true;
                }
                if (!o6Var.get(i).a(s3Var.b.get(i))) {
                    return false;
                }
                i++;
            }
        } else {
            return invokeLZ.booleanValue;
        }
    }
}
