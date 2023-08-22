package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.tieba.ia3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class ja3 extends ia3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTimePicker c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public Date h;
    public Date i;

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends ia3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Date e;
        public Date f;
        public Date g;
        public String h;
        public boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.ia3.a
        public ia3 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ja3 ja3Var = (ja3) super.a();
                ja3Var.j(this.h);
                ja3Var.h(this.i);
                Date date = this.g;
                if (date != null) {
                    ja3Var.k(date.getHours());
                    ja3Var.l(this.g.getMinutes());
                }
                Date date2 = this.e;
                if (date2 != null) {
                    ja3Var.m(date2);
                }
                Date date3 = this.f;
                if (date3 != null) {
                    ja3Var.i(date3);
                }
                return ja3Var;
            }
            return (ia3) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ia3.a
        public ia3 b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return new ja3(context);
            }
            return (ia3) invokeL.objValue;
        }

        public a l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.i = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) {
                this.f = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, date)) == null) {
                this.g = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a p(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) {
                this.e = date;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ja3(Context context) {
        super(context, R.style.obfuscated_res_0x7f1001bc);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = new BdTimePicker(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.c.setLayoutParams(layoutParams);
            this.c.setScrollCycle(true);
            this.c.setStartDate(this.h);
            this.c.setmEndDate(this.i);
            this.c.setHour(this.d);
            this.c.setMinute(this.e);
            this.c.l();
            this.c.setDisabled(this.g);
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.getHour();
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.getMinute();
        }
        return invokeV.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.g = z;
        }
    }

    public void i(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, date) == null) {
            this.i = date;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d = i;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.e = i;
        }
    }

    public void m(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, date) == null) {
            this.h = date;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            if (this.f) {
                getWindow().addFlags(4718592);
            }
            e();
            b().j(this.c);
        }
    }

    @Override // com.baidu.tieba.ca3, android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BdTimePicker bdTimePicker = this.c;
            if (bdTimePicker != null) {
                if (this.d != bdTimePicker.getHour()) {
                    this.c.setHour(this.d);
                }
                if (this.e != this.c.getMinute()) {
                    this.c.setMinute(this.e);
                }
            }
            super.show();
        }
    }
}
