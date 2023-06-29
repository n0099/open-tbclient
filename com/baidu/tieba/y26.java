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
/* loaded from: classes8.dex */
public class y26 extends x26 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a36 q;

    /* loaded from: classes8.dex */
    public class a implements p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y26 a;

        public a(y26 y26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y26Var;
        }

        @Override // com.baidu.tieba.p26
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(a36.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y26(n26 n26Var) {
        super(n26Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n26Var};
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
        this.e = n26Var;
        A(n26Var.A);
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
            o26 o26Var = this.e.c;
            if (o26Var == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f092666);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
                Button button = (Button) i(R.id.obfuscated_res_0x7f090495);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f090490);
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
                o26Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f0924df);
            linearLayout.setBackgroundColor(this.e.H);
            B(linearLayout);
        }
    }

    public final void B(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout) == null) {
            n26 n26Var = this.e;
            a36 a36Var = new a36(linearLayout, n26Var.d, n26Var.z, n26Var.L);
            this.q = a36Var;
            if (this.e.b != null) {
                a36Var.G(new a(this));
            }
            this.q.C(this.e.k);
            n26 n26Var2 = this.e;
            int i2 = n26Var2.h;
            if (i2 != 0 && (i = n26Var2.i) != 0 && i2 <= i) {
                E();
            }
            n26 n26Var3 = this.e;
            Calendar calendar = n26Var3.f;
            if (calendar != null && n26Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    D();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                n26 n26Var4 = this.e;
                Calendar calendar2 = n26Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        D();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = n26Var4.g;
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
            a36 a36Var2 = this.q;
            n26 n26Var5 = this.e;
            a36Var2.y(n26Var5.l, n26Var5.m, n26Var5.n, n26Var5.o, n26Var5.p, n26Var5.q);
            a36 a36Var3 = this.q;
            n26 n26Var6 = this.e;
            a36Var3.N(n26Var6.r, n26Var6.s, n26Var6.t, n26Var6.u, n26Var6.v, n26Var6.w);
            t(this.e.S);
            this.q.s(this.e.j);
            this.q.u(this.e.O);
            this.q.w(this.e.U);
            this.q.A(this.e.Q);
            this.q.M(this.e.M);
            this.q.K(this.e.N);
            this.q.p(this.e.f1136T);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e.a != null) {
            try {
                Date parse = a36.y.parse(this.q.o());
                this.e.a.a(parse, this.m);
                se5.d().c0(parse.getHours(), parse.getMinutes());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a36 a36Var = this.q;
            n26 n26Var = this.e;
            a36Var.E(n26Var.f, n26Var.g);
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

    @Override // com.baidu.tieba.x26
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
            a36 a36Var = this.q;
            a36Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n26 n26Var = this.e;
            if (n26Var.f != null && n26Var.g != null) {
                Calendar calendar = n26Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    n26 n26Var2 = this.e;
                    n26Var2.e = n26Var2.f;
                    return;
                }
                return;
            }
            n26 n26Var3 = this.e;
            Calendar calendar2 = n26Var3.f;
            if (calendar2 != null) {
                n26Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = n26Var3.g;
            if (calendar3 != null) {
                n26Var3.e = calendar3;
            }
        }
    }
}
