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
import java.util.Date;
/* loaded from: classes7.dex */
public class zw5 extends yw5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bx5 q;

    /* loaded from: classes7.dex */
    public class a implements qw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw5 a;

        public a(zw5 zw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw5Var;
        }

        @Override // com.baidu.tieba.qw5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(bx5.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw5(ow5 ow5Var) {
        super(ow5Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ow5Var};
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
        this.e = ow5Var;
        A(ow5Var.A);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (((String) view2.getTag()).equals("submit")) {
                C();
            }
            f();
        }
    }

    public final void A(Context context) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            r();
            n();
            m();
            pw5 pw5Var = this.e.c;
            if (pw5Var == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f09255a);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
                Button button = (Button) i(R.id.obfuscated_res_0x7f09047c);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f090478);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                if (TextUtils.isEmpty(this.e.B)) {
                    str = context.getResources().getString(R.string.pickerview_submit);
                } else {
                    str = this.e.B;
                }
                button.setText(str);
                if (TextUtils.isEmpty(this.e.C)) {
                    str2 = context.getResources().getString(R.string.pickerview_cancel);
                } else {
                    str2 = this.e.C;
                }
                button2.setText(str2);
                if (TextUtils.isEmpty(this.e.D)) {
                    str3 = "";
                } else {
                    str3 = this.e.D;
                }
                textView.setText(str3);
                button.setTextColor(this.e.E);
                button2.setTextColor(this.e.F);
                textView.setTextColor(this.e.G);
                relativeLayout.setBackgroundColor(this.e.I);
                button.setTextSize(this.e.J);
                button2.setTextSize(this.e.J);
                textView.setTextSize(this.e.K);
            } else {
                pw5Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f0923dc);
            linearLayout.setBackgroundColor(this.e.H);
            B(linearLayout);
        }
    }

    public final void B(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout) == null) {
            ow5 ow5Var = this.e;
            bx5 bx5Var = new bx5(linearLayout, ow5Var.d, ow5Var.z, ow5Var.L);
            this.q = bx5Var;
            if (this.e.b != null) {
                bx5Var.G(new a(this));
            }
            this.q.C(this.e.k);
            ow5 ow5Var2 = this.e;
            int i2 = ow5Var2.h;
            if (i2 != 0 && (i = ow5Var2.i) != 0 && i2 <= i) {
                E();
            }
            ow5 ow5Var3 = this.e;
            Calendar calendar = ow5Var3.f;
            if (calendar != null && ow5Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    D();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                ow5 ow5Var4 = this.e;
                Calendar calendar2 = ow5Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        D();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = ow5Var4.g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            D();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        D();
                    }
                }
            }
            F();
            bx5 bx5Var2 = this.q;
            ow5 ow5Var5 = this.e;
            bx5Var2.y(ow5Var5.l, ow5Var5.m, ow5Var5.n, ow5Var5.o, ow5Var5.p, ow5Var5.q);
            bx5 bx5Var3 = this.q;
            ow5 ow5Var6 = this.e;
            bx5Var3.N(ow5Var6.r, ow5Var6.s, ow5Var6.t, ow5Var6.u, ow5Var6.v, ow5Var6.w);
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

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e.a != null) {
            try {
                Date parse = bx5.y.parse(this.q.o());
                this.e.a.a(parse, this.m);
                ga5.d().c0(parse.getHours(), parse.getMinutes());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bx5 bx5Var = this.q;
            ow5 ow5Var = this.e;
            bx5Var.E(ow5Var.f, ow5Var.g);
            z();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.q.I(this.e.h);
            this.q.x(this.e.i);
        }
    }

    @Override // com.baidu.tieba.yw5
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.R;
        }
        return invokeV.booleanValue;
    }

    public final void F() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
            bx5 bx5Var = this.q;
            bx5Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ow5 ow5Var = this.e;
            if (ow5Var.f != null && ow5Var.g != null) {
                Calendar calendar = ow5Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    ow5 ow5Var2 = this.e;
                    ow5Var2.e = ow5Var2.f;
                    return;
                }
                return;
            }
            ow5 ow5Var3 = this.e;
            Calendar calendar2 = ow5Var3.f;
            if (calendar2 != null) {
                ow5Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = ow5Var3.g;
            if (calendar3 != null) {
                ow5Var3.e = calendar3;
            }
        }
    }
}
