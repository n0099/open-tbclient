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
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NewVoteCountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57895e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57896f;

    /* renamed from: g  reason: collision with root package name */
    public View f57897g;

    /* renamed from: h  reason: collision with root package name */
    public View f57898h;

    /* renamed from: i  reason: collision with root package name */
    public View f57899i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f57900j;
    public TextView k;
    public TextView l;
    public CountDownTimer m;
    public b n;

    /* loaded from: classes7.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewVoteCountDownView f57901a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewVoteCountDownView newVoteCountDownView, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoteCountDownView, Long.valueOf(j2), Long.valueOf(j3)};
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
            this.f57901a = newVoteCountDownView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57901a.setContent(0L, 0L, 0L);
                this.f57901a.b();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                long j3 = j2 + 60000;
                long j4 = j3 / 86400000;
                long j5 = j3 % 86400000;
                this.f57901a.setContent(j4, j5 / 3600000, (j5 % 3600000) / 60000);
            }
        }
    }

    /* loaded from: classes7.dex */
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

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.a();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57896f = (TextView) findViewById(R.id.prefix_count_down_view);
            this.f57897g = findViewById(R.id.day_num_container);
            this.f57898h = findViewById(R.id.hour_num_container);
            this.f57899i = findViewById(R.id.minute_num_container);
            this.f57900j = (TextView) findViewById(R.id.day_num_count_down_view);
            this.k = (TextView) findViewById(R.id.hour_num_count_down_view);
            this.l = (TextView) findViewById(R.id.minute_num_count_down_view);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57895e = getContext();
            setOrientation(0);
            setClipToPadding(false);
            setClipChildren(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            layoutParams.gravity = 1;
            setLayoutParams(layoutParams);
            LayoutInflater.from(getContext()).inflate(R.layout.new_vote_count_down_view, (ViewGroup) this, true);
            c();
        }
    }

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) && this.m == null) {
            a aVar = new a(this, j2, 1000L);
            this.m = aVar;
            aVar.start();
        }
    }

    public void onDestroy() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (countDownTimer = this.m) == null) {
            return;
        }
        countDownTimer.cancel();
        this.m = null;
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setViewTextColor(this.f57896f, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f57900j, R.color.CAM_X0105, 1, i2);
            SkinManager.setBackgroundResource(this.f57897g, R.drawable.bg_gradient_round, i2);
            SkinManager.setBackgroundResource(this.f57898h, R.drawable.bg_gradient_round, i2);
            SkinManager.setBackgroundResource(this.f57899i, R.drawable.bg_gradient_round, i2);
            SkinManager.setViewTextColor(this.f57900j, R.color.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1, i2);
        }
    }

    public void setContent(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
            this.f57900j.setText(String.format(string, Long.valueOf(j2)));
            this.k.setText(String.format(string, Long.valueOf(j3)));
            this.l.setText(String.format(string, Long.valueOf(j4)));
        }
    }

    public void setData(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            long j3 = j2 + 60000;
            long j4 = j3 / 86400000;
            long j5 = j3 % 86400000;
            setContent(j4, j5 / 3600000, (j5 % 3600000) / 60000);
            e(j2);
        }
    }

    public void setOnCountDownFinished(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.n = bVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
