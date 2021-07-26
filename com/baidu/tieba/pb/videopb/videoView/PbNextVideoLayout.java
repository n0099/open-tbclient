package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
/* loaded from: classes4.dex */
public class PbNextVideoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f19946e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f19947f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19948g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19949h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19950i;
    public ProgressBar j;
    public boolean k;
    public boolean l;
    public a m;

    /* loaded from: classes4.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbNextVideoLayout f19951a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbNextVideoLayout pbNextVideoLayout, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNextVideoLayout, Long.valueOf(j), Long.valueOf(j2)};
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
            this.f19951a = pbNextVideoLayout;
            pbNextVideoLayout.l = true;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbNextVideoLayout pbNextVideoLayout = this.f19951a;
                pbNextVideoLayout.l = false;
                pbNextVideoLayout.performClick();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f19951a.j.setProgress(((int) (5000 - j)) * 2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19946e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }

    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            getLayoutParams().height = l.g(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
            this.f19947f.getLayoutParams().width = l.g(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
            this.f19949h.setTextSize(0, l.g(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
            ((LinearLayout.LayoutParams) this.f19949h.getLayoutParams()).topMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
            ((RelativeLayout.LayoutParams) this.f19950i.getLayoutParams()).topMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
            ((RelativeLayout.LayoutParams) this.f19950i.getLayoutParams()).rightMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
            this.f19946e = (!z2 || z) ? 50 : 25;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            RelativeLayout.inflate(context, R.layout.pb_next_video_layout, this);
            this.f19947f = (TbImageView) findViewById(R.id.pb_next_video_img);
            this.f19948g = (TextView) findViewById(R.id.pb_next_video_txt);
            this.f19949h = (TextView) findViewById(R.id.pb_next_video_title);
            this.f19950i = (ImageView) findViewById(R.id.pb_next_video_close);
            this.j = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19950i, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, null);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = true;
            this.f19948g.setText(R.string.pb_video_next_play);
            a aVar = this.m;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, 5000 - this.j.getProgress(), this.f19946e);
            this.m = aVar2;
            aVar2.start();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = false;
            a aVar = this.m;
            if (aVar != null) {
                aVar.cancel();
            }
            this.f19948g.setText(R.string.pb_video_next_video);
            this.j.setProgress(0);
        }
    }

    public void setDate(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) || b2Var == null || b2Var.m1() == null) {
            return;
        }
        this.f19947f.M(b2Var.m1().thumbnail_url, 10, false);
        this.f19948g.setText(R.string.pb_video_next_play);
        this.f19949h.setText(b2Var.getTitle());
        this.j.setProgress(0);
    }

    public void setIsCountDownValid(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.k == z) {
            return;
        }
        this.k = z;
        if (getVisibility() == 0) {
            if (z) {
                d();
            } else {
                e();
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.f19950i.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                if (this.k) {
                    d();
                    return;
                } else {
                    e();
                    return;
                }
            }
            this.j.setProgress(0);
            a aVar = this.m;
            if (aVar != null) {
                aVar.cancel();
            }
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
        this.f19946e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f19946e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }
}
