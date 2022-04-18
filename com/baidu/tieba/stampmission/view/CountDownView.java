package com.baidu.tieba.stampmission.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
import com.repackage.vr4;
/* loaded from: classes4.dex */
public class CountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public CountDownTimer f;

    /* loaded from: classes4.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CountDownView countDownView, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {countDownView, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                long j2 = j / 86400000;
                long j3 = j % 86400000;
                long j4 = j3 / 3600000;
                long j5 = j3 % 3600000;
                this.a.h(j4 + (j2 * 24), j5 / 60000, (j5 % 60000) / 1000);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            vr4 d = vr4.d(textView);
            d.n(R.string.J_X06);
            d.z(R.dimen.T_X04);
            d.v(R.color.CAM_X0302);
            d.A(R.string.F_X02);
            d.f(R.color.CAM_X0206);
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.e = new TextView(getContext());
            this.e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.e.setText(getContext().getResources().getString(i));
            vr4 d = vr4.d(this.e);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X08);
            addView(this.e);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = this.a;
            if (textView != null) {
                vr4 d = vr4.d(textView);
                d.v(R.color.CAM_X0108);
                d.z(R.dimen.T_X08);
            }
            TextView textView2 = this.b;
            if (textView2 != null) {
                setTimeSkin(textView2);
            }
            TextView textView3 = this.c;
            if (textView3 != null) {
                setTimeSkin(textView3);
            }
            TextView textView4 = this.d;
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
            this.b = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds104), oi.f(getContext(), R.dimen.tbds104));
            layoutParams.setMargins(oi.f(getContext(), R.dimen.M_W_X004), 0, oi.f(getContext(), R.dimen.M_W_X004), 0);
            this.b.setLayoutParams(layoutParams);
            this.b.setGravity(17);
            addView(this.b);
            b(R.string.obfuscated_res_0x7f0f088e);
            this.c = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds104), oi.f(getContext(), R.dimen.tbds104));
            layoutParams2.setMargins(oi.f(getContext(), R.dimen.M_W_X004), 0, oi.f(getContext(), R.dimen.M_W_X004), 0);
            this.c.setLayoutParams(layoutParams2);
            this.c.setGravity(17);
            addView(this.c);
            b(R.string.obfuscated_res_0x7f0f0abc);
            this.d = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds104), oi.f(getContext(), R.dimen.tbds104));
            layoutParams3.setMargins(oi.f(getContext(), R.dimen.M_W_X004), 0, oi.f(getContext(), R.dimen.M_W_X004), 0);
            this.d.setLayoutParams(layoutParams3);
            this.d.setGravity(17);
            addView(this.d);
            b(R.string.obfuscated_res_0x7f0f13ce);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = new TextView(getContext());
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.a.setText(R.string.obfuscated_res_0x7f0f0450);
            addView(this.a);
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

    public final void h(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f00d3);
            this.b.setText(String.format(string, Long.valueOf(j)));
            this.c.setText(String.format(string, Long.valueOf(j2)));
            this.d.setText(String.format(string, Long.valueOf(j3)));
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            a aVar = new a(this, j, 1000L);
            this.f = aVar;
            aVar.start();
        }
    }

    public void j() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (countDownTimer = this.f) == null) {
            return;
        }
        countDownTimer.cancel();
        this.f = null;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
