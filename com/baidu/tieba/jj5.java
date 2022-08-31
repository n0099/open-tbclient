package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class jj5 extends ij5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lj5 q;

    /* loaded from: classes4.dex */
    public class a implements aj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj5 a;

        public a(jj5 jj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jj5Var;
        }

        @Override // com.baidu.tieba.aj5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(lj5.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jj5(yi5 yi5Var) {
        super(yi5Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi5Var};
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
        this.e = yi5Var;
        y(yi5Var.A);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.e.a == null) {
            return;
        }
        try {
            this.e.a.a(lj5.y.parse(this.q.o()), this.m);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lj5 lj5Var = this.q;
            yi5 yi5Var = this.e;
            lj5Var.E(yi5Var.f, yi5Var.g);
            x();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q.I(this.e.h);
            this.q.x(this.e.i);
        }
    }

    public final void D() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.e.e;
            if (calendar2 == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                i = calendar.get(1);
                i2 = calendar.get(2);
                i3 = calendar.get(5);
                i4 = calendar.get(11);
                i5 = calendar.get(12);
                i6 = calendar.get(13);
            } else {
                i = calendar2.get(1);
                i2 = this.e.e.get(2);
                i3 = this.e.e.get(5);
                i4 = this.e.e.get(11);
                i5 = this.e.e.get(12);
                i6 = this.e.e.get(13);
            }
            int i7 = i4;
            int i8 = i3;
            int i9 = i2;
            lj5 lj5Var = this.q;
            lj5Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    @Override // com.baidu.tieba.ij5
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e.R : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (((String) view2.getTag()).equals("submit")) {
                A();
            }
            f();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            yi5 yi5Var = this.e;
            if (yi5Var.f != null && yi5Var.g != null) {
                Calendar calendar = yi5Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    yi5 yi5Var2 = this.e;
                    yi5Var2.e = yi5Var2.f;
                    return;
                }
                return;
            }
            yi5 yi5Var3 = this.e;
            Calendar calendar2 = yi5Var3.f;
            if (calendar2 != null) {
                yi5Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = yi5Var3.g;
            if (calendar3 != null) {
                yi5Var3.e = calendar3;
            }
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            r();
            n();
            m();
            zi5 zi5Var = this.e.c;
            if (zi5Var == null) {
                LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0720, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f092307);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.obfuscated_res_0x7f091c51);
                Button button = (Button) i(R.id.obfuscated_res_0x7f090414);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f090410);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.e.B) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e85) : this.e.B);
                button2.setText(TextUtils.isEmpty(this.e.C) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e7f) : this.e.C);
                textView.setText(TextUtils.isEmpty(this.e.D) ? "" : this.e.D);
                button.setTextColor(this.e.E);
                button2.setTextColor(this.e.F);
                textView.setTextColor(this.e.G);
                relativeLayout.setBackgroundColor(this.e.I);
                button.setTextSize(this.e.J);
                button2.setTextSize(this.e.J);
                textView.setTextSize(this.e.K);
            } else {
                zi5Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f092197);
            linearLayout.setBackgroundColor(this.e.H);
            z(linearLayout);
        }
    }

    public final void z(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearLayout) == null) {
            yi5 yi5Var = this.e;
            lj5 lj5Var = new lj5(linearLayout, yi5Var.d, yi5Var.z, yi5Var.L);
            this.q = lj5Var;
            if (this.e.b != null) {
                lj5Var.G(new a(this));
            }
            this.q.C(this.e.k);
            yi5 yi5Var2 = this.e;
            int i2 = yi5Var2.h;
            if (i2 != 0 && (i = yi5Var2.i) != 0 && i2 <= i) {
                C();
            }
            yi5 yi5Var3 = this.e;
            Calendar calendar = yi5Var3.f;
            if (calendar != null && yi5Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    B();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                yi5 yi5Var4 = this.e;
                Calendar calendar2 = yi5Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        B();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = yi5Var4.g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            B();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        B();
                    }
                }
            }
            D();
            lj5 lj5Var2 = this.q;
            yi5 yi5Var5 = this.e;
            lj5Var2.y(yi5Var5.l, yi5Var5.m, yi5Var5.n, yi5Var5.o, yi5Var5.p, yi5Var5.q);
            lj5 lj5Var3 = this.q;
            yi5 yi5Var6 = this.e;
            lj5Var3.N(yi5Var6.r, yi5Var6.s, yi5Var6.t, yi5Var6.u, yi5Var6.v, yi5Var6.w);
            t(this.e.S);
            this.q.s(this.e.j);
            this.q.u(this.e.O);
            this.q.w(this.e.U);
            this.q.A(this.e.Q);
            this.q.M(this.e.M);
            this.q.K(this.e.N);
            this.q.p(this.e.T);
        }
    }
}
