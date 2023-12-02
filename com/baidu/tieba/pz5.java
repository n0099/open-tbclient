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
public class pz5 extends oz5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rz5 q;

    /* loaded from: classes7.dex */
    public class a implements hz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz5 a;

        public a(pz5 pz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz5Var;
        }

        @Override // com.baidu.tieba.hz5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(rz5.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pz5(fz5 fz5Var) {
        super(fz5Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fz5Var};
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
        this.e = fz5Var;
        B(fz5Var.A);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (((String) view2.getTag()).equals("submit")) {
                D();
            }
            f();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fz5 fz5Var = this.e;
            if (fz5Var.f != null && fz5Var.g != null) {
                Calendar calendar = fz5Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    fz5 fz5Var2 = this.e;
                    fz5Var2.e = fz5Var2.f;
                    return;
                }
                return;
            }
            fz5 fz5Var3 = this.e;
            Calendar calendar2 = fz5Var3.f;
            if (calendar2 != null) {
                fz5Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = fz5Var3.g;
            if (calendar3 != null) {
                fz5Var3.e = calendar3;
            }
        }
    }

    public final void B(Context context) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            s();
            o();
            n();
            gz5 gz5Var = this.e.c;
            if (gz5Var == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f0927c8);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
                Button button = (Button) i(R.id.obfuscated_res_0x7f0904df);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f0904da);
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
                gz5Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f092655);
            linearLayout.setBackgroundColor(this.e.H);
            C(linearLayout);
        }
    }

    public final void C(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linearLayout) == null) {
            fz5 fz5Var = this.e;
            rz5 rz5Var = new rz5(linearLayout, fz5Var.d, fz5Var.z, fz5Var.L);
            this.q = rz5Var;
            if (this.e.b != null) {
                rz5Var.G(new a(this));
            }
            this.q.C(this.e.k);
            fz5 fz5Var2 = this.e;
            int i2 = fz5Var2.h;
            if (i2 != 0 && (i = fz5Var2.i) != 0 && i2 <= i) {
                F();
            }
            fz5 fz5Var3 = this.e;
            Calendar calendar = fz5Var3.f;
            if (calendar != null && fz5Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    E();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                fz5 fz5Var4 = this.e;
                Calendar calendar2 = fz5Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        E();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = fz5Var4.g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            E();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        E();
                    }
                }
            }
            G();
            rz5 rz5Var2 = this.q;
            fz5 fz5Var5 = this.e;
            rz5Var2.y(fz5Var5.l, fz5Var5.m, fz5Var5.n, fz5Var5.o, fz5Var5.p, fz5Var5.q);
            rz5 rz5Var3 = this.q;
            fz5 fz5Var6 = this.e;
            rz5Var3.N(fz5Var6.r, fz5Var6.s, fz5Var6.t, fz5Var6.u, fz5Var6.v, fz5Var6.w);
            u(this.e.S);
            this.q.s(this.e.j);
            this.q.u(this.e.O);
            this.q.w(this.e.U);
            this.q.A(this.e.Q);
            this.q.M(this.e.M);
            this.q.K(this.e.N);
            this.q.p(this.e.f1098T);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.e.a != null) {
            try {
                Date parse = rz5.y.parse(this.q.o());
                this.e.a.onTimeSelect(parse, this.m);
                ia5.e().e0(parse.getHours(), parse.getMinutes());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rz5 rz5Var = this.q;
            fz5 fz5Var = this.e;
            rz5Var.E(fz5Var.f, fz5Var.g);
            A();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.q.I(this.e.h);
            this.q.x(this.e.i);
        }
    }

    @Override // com.baidu.tieba.oz5
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e.R;
        }
        return invokeV.booleanValue;
    }

    public final void G() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
            rz5 rz5Var = this.q;
            rz5Var.D(i, i9, i8, i7, i5, i6);
        }
    }
}
