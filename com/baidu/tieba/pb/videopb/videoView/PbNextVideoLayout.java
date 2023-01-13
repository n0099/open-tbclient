package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbNextVideoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public ProgressBar f;
    public boolean g;
    public boolean h;
    public a i;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNextVideoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbNextVideoLayout pbNextVideoLayout, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNextVideoLayout, Long.valueOf(j), Long.valueOf(j2)};
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
            this.a = pbNextVideoLayout;
            pbNextVideoLayout.h = true;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbNextVideoLayout pbNextVideoLayout = this.a;
                pbNextVideoLayout.h = false;
                pbNextVideoLayout.performClick();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.f.setProgress(((int) (5000 - j)) * 2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNextVideoLayout(Context context) {
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
        this.a = 50;
        this.g = true;
        this.h = true;
        c(context);
    }

    public void setDate(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.b.K(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            this.c.setText(R.string.obfuscated_res_0x7f0f0e95);
            this.d.setText(threadData.getTitle());
            this.f.setProgress(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = 50;
        this.g = true;
        this.h = true;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 50;
        this.g = true;
        this.h = true;
        c(context);
    }

    public void setIsCountDownValid(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.g != z) {
            this.g = z;
            if (getVisibility() == 0) {
                if (z) {
                    d();
                } else {
                    e();
                }
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.e.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                if (this.g) {
                    d();
                    return;
                } else {
                    e();
                    return;
                }
            }
            this.f.setProgress(0);
            a aVar = this.i;
            if (aVar != null) {
                aVar.cancel();
            }
        }
    }

    public void b(boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Context context = getContext();
            if (z2 && !z) {
                i = R.dimen.tbds267;
            } else {
                i = R.dimen.tbds156;
            }
            layoutParams.height = zi.g(context, i);
            ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
            Context context2 = getContext();
            if (z2 && !z) {
                i2 = R.dimen.tbds470;
            } else {
                i2 = R.dimen.tbds276;
            }
            layoutParams2.width = zi.g(context2, i2);
            TextView textView = this.d;
            Context context3 = getContext();
            int i6 = R.dimen.tbds52;
            int i7 = R.dimen.tbds42;
            if (z2 && !z) {
                i3 = R.dimen.tbds52;
            } else {
                i3 = R.dimen.tbds42;
            }
            textView.setTextSize(0, zi.g(context3, i3));
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            Context context4 = getContext();
            if (z2 && !z) {
                i4 = R.dimen.tbds22;
            } else {
                i4 = R.dimen.tbds8;
            }
            layoutParams3.topMargin = zi.g(context4, i4);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            Context context5 = getContext();
            if (!z2 || z) {
                i7 = R.dimen.tbds20;
            }
            layoutParams4.topMargin = zi.g(context5, i7);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            Context context6 = getContext();
            if (!z2 || z) {
                i6 = R.dimen.tbds44;
            }
            layoutParams5.rightMargin = zi.g(context6, i6);
            if (z2 && !z) {
                i5 = 25;
            } else {
                i5 = 50;
            }
            this.a = i5;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0701, this);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091916);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091919);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091918);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091915);
            this.f = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091917);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, null);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = true;
            this.c.setText(R.string.obfuscated_res_0x7f0f0e95);
            a aVar = this.i;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, 5000 - this.f.getProgress(), this.a);
            this.i = aVar2;
            aVar2.start();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = false;
            a aVar = this.i;
            if (aVar != null) {
                aVar.cancel();
            }
            this.c.setText(R.string.obfuscated_res_0x7f0f0e96);
            this.f.setProgress(0);
        }
    }
}
