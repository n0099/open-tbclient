package com.baidu.tieba;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class sr0 implements cw0 {
    public static /* synthetic */ Interceptable $ic;
    public static final tr0 i;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Object> a;
    public String b;
    public Object c;
    public int d;
    public int e;
    public int f;
    public StringBuilder g;
    public int h;

    @Override // com.baidu.tieba.cw0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948160888, "Lcom/baidu/tieba/sr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948160888, "Lcom/baidu/tieba/sr0;");
                return;
            }
        }
        i = new tr0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sr0() {
        this("");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Object k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cw0
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.clear();
        }
    }

    @Override // com.baidu.tieba.cw0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b = "";
            this.c = null;
            this.e = -1;
            this.d = -1;
            this.f = 0;
            this.h = 0;
            this.a.clear();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            i.d(this);
        }
    }

    public sr0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>(3);
        this.d = -1;
        this.e = -1;
        this.f = 0;
        this.h = 0;
        this.b = str;
    }

    public static sr0 a(@NonNull sr0 sr0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sr0Var)) == null) {
            sr0 a = i.a();
            a.w(sr0Var.d);
            a.q(sr0Var.b);
            a.u(sr0Var.c);
            a.v(sr0Var.e);
            a.t(sr0Var.f);
            a.r(sr0Var.a);
            a.s(sr0Var.h);
            return a;
        }
        return (sr0) invokeL.objValue;
    }

    public static sr0 n(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            sr0 a = i.a();
            a.w(i2);
            a.q(str);
            return a;
        }
        return (sr0) invokeLI.objValue;
    }

    public int h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            Object obj = this.a.get(i2);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public void o(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, obj) == null) {
            this.a.put(i2, obj);
        }
    }

    public boolean b(@NonNull ss0 ss0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ss0Var)) == null) {
            if (k() != ss0Var && (l() == -1 || l() == ss0Var.getType())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return e(i2, false);
        }
        return invokeI.booleanValue;
    }

    public Object f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return this.a.get(i2);
        }
        return invokeI.objValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return h(i2, 0);
        }
        return invokeI.intValue;
    }

    public void q(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.b = str;
        }
    }

    public void r(@NonNull SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sparseArray) == null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.a.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.h = i2;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f = i2;
        }
    }

    public void u(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, obj) == null) {
            this.c = obj;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.e = i2;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.d = i2;
        }
    }

    public boolean e(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Object obj = this.a.get(i2);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = this.g;
            if (sb == null) {
                this.g = new StringBuilder();
            } else if (sb.length() > 0) {
                StringBuilder sb2 = this.g;
                sb2.delete(0, sb2.length());
            }
            StringBuilder sb3 = this.g;
            sb3.append("Action :");
            sb3.append(this.b);
            sb3.append(", type :");
            sb3.append(this.d);
            sb3.append(", from :");
            sb3.append(this.c);
            sb3.append(", priority :");
            sb3.append(this.f);
            sb3.append(", targetType :");
            sb3.append(this.e);
            sb3.append(", bundle :");
            sb3.append(this.a.toString());
            sb3.append(", hash :");
            sb3.append(hashCode());
            return this.g.toString();
        }
        return (String) invokeV.objValue;
    }
}
