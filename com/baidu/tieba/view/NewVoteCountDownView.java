package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi;
/* loaded from: classes4.dex */
public class NewVoteCountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public View c;
    public View d;
    public View e;
    public TextView f;
    public TextView g;
    public TextView h;
    public CountDownTimer i;
    public b j;

    /* loaded from: classes4.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewVoteCountDownView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewVoteCountDownView newVoteCountDownView, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoteCountDownView, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = newVoteCountDownView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setContent(0L, 0L, 0L);
                this.a.b();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                long j2 = j + 60000;
                long j3 = j2 / 86400000;
                long j4 = j2 % 86400000;
                this.a.setContent(j3, j4 / 3600000, (j4 % 3600000) / 60000);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewVoteCountDownView(Context context) {
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

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.j) == null) {
            return;
        }
        bVar.a();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0918ce);
            this.c = findViewById(R.id.obfuscated_res_0x7f090765);
            this.d = findViewById(R.id.obfuscated_res_0x7f090dfb);
            this.e = findViewById(R.id.obfuscated_res_0x7f091420);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090766);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090dfc);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091421);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = getContext();
            setOrientation(0);
            setClipToPadding(false);
            setClipChildren(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            layoutParams.gravity = 1;
            setLayoutParams(layoutParams);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0611, (ViewGroup) this, true);
            c();
        }
    }

    public void e() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (countDownTimer = this.i) == null) {
            return;
        }
        countDownTimer.cancel();
        this.i = null;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0105, 1, i);
            SkinManager.setBackgroundResource(this.c, R.drawable.bg_gradient_round, i);
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_gradient_round, i);
            SkinManager.setBackgroundResource(this.e, R.drawable.bg_gradient_round, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0101, 1, i);
        }
    }

    public final void g(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && this.i == null) {
            a aVar = new a(this, j, 1000L);
            this.i = aVar;
            aVar.start();
        }
    }

    public void setContent(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f00d3);
            this.f.setText(String.format(string, Long.valueOf(j)));
            this.g.setText(String.format(string, Long.valueOf(j2)));
            this.h.setText(String.format(string, Long.valueOf(j3)));
        }
    }

    public void setData(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            long j2 = j + 60000;
            long j3 = j2 / 86400000;
            long j4 = j2 % 86400000;
            setContent(j3, j4 / 3600000, (j4 % 3600000) / 60000);
            g(j);
        }
    }

    public void setOnCountDownFinished(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.j = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewVoteCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }
}
