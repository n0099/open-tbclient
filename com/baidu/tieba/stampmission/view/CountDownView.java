package com.baidu.tieba.stampmission.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.v.c;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class CountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COUNT_DOWN_INTERVAL = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48268e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48269f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48270g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48271h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48272i;

    /* renamed from: j  reason: collision with root package name */
    public CountDownTimer f48273j;

    /* loaded from: classes13.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CountDownView countDownView, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {countDownView, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = countDownView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h(0L, 0L, 0L);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                long j3 = j2 / 86400000;
                long j4 = j2 % 86400000;
                long j5 = j4 / 3600000;
                long j6 = j4 % 3600000;
                this.a.h(j5 + (j3 * 24), j6 / 60000, (j6 % 60000) / 1000);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void setTimeSkin(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, textView) == null) {
            c d2 = c.d(textView);
            d2.n(j.J_X06);
            d2.z(e.T_X04);
            d2.v(d.CAM_X0302);
            d2.A(j.F_X02);
            d2.f(d.CAM_X0206);
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f48272i = new TextView(getContext());
            this.f48272i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f48272i.setText(getContext().getResources().getString(i2));
            c d2 = c.d(this.f48272i);
            d2.v(d.CAM_X0105);
            d2.z(e.T_X08);
            addView(this.f48272i);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = this.f48268e;
            if (textView != null) {
                c d2 = c.d(textView);
                d2.v(d.CAM_X0108);
                d2.z(e.T_X08);
            }
            TextView textView2 = this.f48269f;
            if (textView2 != null) {
                setTimeSkin(textView2);
            }
            TextView textView3 = this.f48270g;
            if (textView3 != null) {
                setTimeSkin(textView3);
            }
            TextView textView4 = this.f48271h;
            if (textView4 != null) {
                setTimeSkin(textView4);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            setOrientation(0);
            setGravity(16);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f48269f = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(getContext(), e.tbds104), n.f(getContext(), e.tbds104));
            layoutParams.setMargins(n.f(getContext(), e.M_W_X004), 0, n.f(getContext(), e.M_W_X004), 0);
            this.f48269f.setLayoutParams(layoutParams);
            this.f48269f.setGravity(17);
            addView(this.f48269f);
            b(j.hour);
            this.f48270g = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(n.f(getContext(), e.tbds104), n.f(getContext(), e.tbds104));
            layoutParams2.setMargins(n.f(getContext(), e.M_W_X004), 0, n.f(getContext(), e.M_W_X004), 0);
            this.f48270g.setLayoutParams(layoutParams2);
            this.f48270g.setGravity(17);
            addView(this.f48270g);
            b(j.minute);
            this.f48271h = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(n.f(getContext(), e.tbds104), n.f(getContext(), e.tbds104));
            layoutParams3.setMargins(n.f(getContext(), e.M_W_X004), 0, n.f(getContext(), e.M_W_X004), 0);
            this.f48271h.setLayoutParams(layoutParams3);
            this.f48271h.setGravity(17);
            addView(this.f48271h);
            b(j.time_second);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48268e = new TextView(getContext());
            this.f48268e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f48268e.setText(j.count_down_title);
            addView(this.f48268e);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
            f();
            e();
            c();
        }
    }

    public final void h(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            String string = TbadkCoreApplication.getInst().getString(j.add_zero_when_less_ten);
            this.f48269f.setText(String.format(string, Long.valueOf(j2)));
            this.f48270g.setText(String.format(string, Long.valueOf(j3)));
            this.f48271h.setText(String.format(string, Long.valueOf(j4)));
        }
    }

    public void startCountDown(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            a aVar = new a(this, j2, 1000L);
            this.f48273j = aVar;
            aVar.start();
        }
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (countDownTimer = this.f48273j) == null) {
            return;
        }
        countDownTimer.cancel();
        this.f48273j = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        g();
    }
}
