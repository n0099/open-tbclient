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
import c.a.q0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COUNT_DOWN_INTERVAL = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46684e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46685f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46686g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46687h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46688i;

    /* renamed from: j  reason: collision with root package name */
    public CountDownTimer f46689j;

    /* loaded from: classes6.dex */
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
            d2.n(R.string.J_X06);
            d2.z(R.dimen.T_X04);
            d2.v(R.color.CAM_X0302);
            d2.A(R.string.F_X02);
            d2.f(R.color.CAM_X0206);
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f46688i = new TextView(getContext());
            this.f46688i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f46688i.setText(getContext().getResources().getString(i2));
            c d2 = c.d(this.f46688i);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X08);
            addView(this.f46688i);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = this.f46684e;
            if (textView != null) {
                c d2 = c.d(textView);
                d2.v(R.color.CAM_X0108);
                d2.z(R.dimen.T_X08);
            }
            TextView textView2 = this.f46685f;
            if (textView2 != null) {
                setTimeSkin(textView2);
            }
            TextView textView3 = this.f46686g;
            if (textView3 != null) {
                setTimeSkin(textView3);
            }
            TextView textView4 = this.f46687h;
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
            this.f46685f = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds104), n.f(getContext(), R.dimen.tbds104));
            layoutParams.setMargins(n.f(getContext(), R.dimen.M_W_X004), 0, n.f(getContext(), R.dimen.M_W_X004), 0);
            this.f46685f.setLayoutParams(layoutParams);
            this.f46685f.setGravity(17);
            addView(this.f46685f);
            b(R.string.hour);
            this.f46686g = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds104), n.f(getContext(), R.dimen.tbds104));
            layoutParams2.setMargins(n.f(getContext(), R.dimen.M_W_X004), 0, n.f(getContext(), R.dimen.M_W_X004), 0);
            this.f46686g.setLayoutParams(layoutParams2);
            this.f46686g.setGravity(17);
            addView(this.f46686g);
            b(R.string.minute);
            this.f46687h = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds104), n.f(getContext(), R.dimen.tbds104));
            layoutParams3.setMargins(n.f(getContext(), R.dimen.M_W_X004), 0, n.f(getContext(), R.dimen.M_W_X004), 0);
            this.f46687h.setLayoutParams(layoutParams3);
            this.f46687h.setGravity(17);
            addView(this.f46687h);
            b(R.string.time_second);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f46684e = new TextView(getContext());
            this.f46684e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f46684e.setText(R.string.count_down_title);
            addView(this.f46684e);
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
            String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
            this.f46685f.setText(String.format(string, Long.valueOf(j2)));
            this.f46686g.setText(String.format(string, Long.valueOf(j3)));
            this.f46687h.setText(String.format(string, Long.valueOf(j4)));
        }
    }

    public void startCountDown(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            a aVar = new a(this, j2, 1000L);
            this.f46689j = aVar;
            aVar.start();
        }
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (countDownTimer = this.f46689j) == null) {
            return;
        }
        countDownTimer.cancel();
        this.f46689j = null;
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
