package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.timepicker.pickerview.listener.OnTimeSelectListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class z06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a16 a;

    public z06(Context context, OnTimeSelectListener onTimeSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onTimeSelectListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a16 a16Var = new a16(2);
        this.a = a16Var;
        a16Var.A = context;
        a16Var.a = onTimeSelectListener;
    }

    public k16 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new k16(this.a);
        }
        return (k16) invokeV.objValue;
    }

    public z06 b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.a.f1087T = z;
            return this;
        }
        return (z06) invokeZ.objValue;
    }

    public z06 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.a.R = z;
            return this;
        }
        return (z06) invokeZ.objValue;
    }

    public z06 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.a.P = i;
            return this;
        }
        return (z06) invokeI.objValue;
    }

    public z06 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a.H = i;
            return this;
        }
        return (z06) invokeI.objValue;
    }

    public z06 f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.a.L = i;
            return this;
        }
        return (z06) invokeI.objValue;
    }

    public z06 g(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, calendar)) == null) {
            this.a.e = calendar;
            return this;
        }
        return (z06) invokeL.objValue;
    }

    public z06 h(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            this.a.y = viewGroup;
            return this;
        }
        return (z06) invokeL.objValue;
    }

    public z06 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.a.O = i;
            return this;
        }
        return (z06) invokeI.objValue;
    }

    public z06 l(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            this.a.Q = f;
            return this;
        }
        return (z06) invokeF.objValue;
    }

    public z06 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.a.N = i;
            return this;
        }
        return (z06) invokeI.objValue;
    }

    public z06 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.a.M = i;
            return this;
        }
        return (z06) invokeI.objValue;
    }

    public z06 p(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zArr)) == null) {
            this.a.d = zArr;
            return this;
        }
        return (z06) invokeL.objValue;
    }

    public z06 j(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            a16 a16Var = this.a;
            a16Var.l = str;
            a16Var.m = str2;
            a16Var.n = str3;
            a16Var.o = str4;
            a16Var.p = str5;
            a16Var.q = str6;
            return this;
        }
        return (z06) invokeCommon.objValue;
    }

    public z06 k(int i, b16 b16Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, b16Var)) == null) {
            a16 a16Var = this.a;
            a16Var.x = i;
            a16Var.c = b16Var;
            return this;
        }
        return (z06) invokeIL.objValue;
    }

    public z06 o(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            a16 a16Var = this.a;
            a16Var.r = i;
            a16Var.s = i2;
            a16Var.t = i3;
            a16Var.u = i4;
            a16Var.v = i5;
            a16Var.w = i6;
            return this;
        }
        return (z06) invokeCommon.objValue;
    }
}
