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
import b.a.q0.s.q.d2;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbNextVideoLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52826e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52827f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52828g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52829h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f52830i;
    public boolean isManualFinish;
    public ProgressBar j;
    public boolean k;
    public a l;

    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbNextVideoLayout f52831a;

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
            this.f52831a = pbNextVideoLayout;
            pbNextVideoLayout.isManualFinish = true;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbNextVideoLayout pbNextVideoLayout = this.f52831a;
                pbNextVideoLayout.isManualFinish = false;
                pbNextVideoLayout.performClick();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f52831a.j.setProgress(((int) (5000 - j)) * 2);
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
        this.f52826e = 50;
        this.k = true;
        this.isManualFinish = true;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            RelativeLayout.inflate(context, j.pb_next_video_layout, this);
            this.f52827f = (TbImageView) findViewById(i.pb_next_video_img);
            this.f52828g = (TextView) findViewById(i.pb_next_video_txt);
            this.f52829h = (TextView) findViewById(i.pb_next_video_title);
            this.f52830i = (ImageView) findViewById(i.pb_next_video_close);
            this.j = (ProgressBar) findViewById(i.pb_next_video_progress_bar);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52830i, h.icon_pure_close16_n_svg, f.CAM_X0622, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = true;
            this.f52828g.setText(l.pb_video_next_play);
            a aVar = this.l;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, 5000 - this.j.getProgress(), this.f52826e);
            this.l = aVar2;
            aVar2.start();
        }
    }

    public void changeViewLayout(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            getLayoutParams().height = b.a.e.e.p.l.g(getContext(), (!z2 || z) ? g.tbds156 : g.tbds267);
            this.f52827f.getLayoutParams().width = b.a.e.e.p.l.g(getContext(), (!z2 || z) ? g.tbds276 : g.tbds470);
            this.f52829h.setTextSize(0, b.a.e.e.p.l.g(getContext(), (!z2 || z) ? g.tbds42 : g.tbds52));
            ((LinearLayout.LayoutParams) this.f52829h.getLayoutParams()).topMargin = b.a.e.e.p.l.g(getContext(), (!z2 || z) ? g.tbds8 : g.tbds22);
            ((RelativeLayout.LayoutParams) this.f52830i.getLayoutParams()).topMargin = b.a.e.e.p.l.g(getContext(), (!z2 || z) ? g.tbds20 : g.tbds42);
            ((RelativeLayout.LayoutParams) this.f52830i.getLayoutParams()).rightMargin = b.a.e.e.p.l.g(getContext(), (!z2 || z) ? g.tbds44 : g.tbds52);
            this.f52826e = (!z2 || z) ? 50 : 25;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = false;
            a aVar = this.l;
            if (aVar != null) {
                aVar.cancel();
            }
            this.f52828g.setText(l.pb_video_next_video);
            this.j.setProgress(0);
        }
    }

    public void setDate(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.q1() == null) {
            return;
        }
        this.f52827f.startLoad(d2Var.q1().thumbnail_url, 10, false);
        this.f52828g.setText(l.pb_video_next_play);
        this.f52829h.setText(d2Var.getTitle());
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
                c();
            } else {
                d();
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.f52830i.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                if (this.k) {
                    c();
                    return;
                } else {
                    d();
                    return;
                }
            }
            this.j.setProgress(0);
            a aVar = this.l;
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
        this.f52826e = 50;
        this.k = true;
        this.isManualFinish = true;
        b(context);
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
        this.f52826e = 50;
        this.k = true;
        this.isManualFinish = true;
        b(context);
    }
}
