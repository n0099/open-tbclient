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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
/* loaded from: classes5.dex */
public class PbNextVideoLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f20100e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20101f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20102g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20103h;
    public ImageView i;
    public ProgressBar j;
    public boolean k;
    public boolean l;
    public a m;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.l = true;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout pbNextVideoLayout = PbNextVideoLayout.this;
            pbNextVideoLayout.l = false;
            pbNextVideoLayout.performClick();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.j.setProgress(((int) (5000 - j)) * 2);
        }
    }

    public PbNextVideoLayout(Context context) {
        super(context);
        this.f20100e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }

    public void b(boolean z, boolean z2) {
        getLayoutParams().height = l.g(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.f20101f.getLayoutParams().width = l.g(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.f20103h.setTextSize(0, l.g(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.f20103h.getLayoutParams()).topMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).topMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).rightMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.f20100e = (!z2 || z) ? 50 : 25;
    }

    public final void c(Context context) {
        RelativeLayout.inflate(context, R.layout.pb_next_video_layout, this);
        this.f20101f = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.f20102g = (TextView) findViewById(R.id.pb_next_video_txt);
        this.f20103h = (TextView) findViewById(R.id.pb_next_video_title);
        this.i = (ImageView) findViewById(R.id.pb_next_video_close);
        this.j = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, null);
    }

    public final void d() {
        this.k = true;
        this.f20102g.setText(R.string.pb_video_next_play);
        a aVar = this.m;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(5000 - this.j.getProgress(), this.f20100e);
        this.m = aVar2;
        aVar2.start();
    }

    public final void e() {
        this.k = false;
        a aVar = this.m;
        if (aVar != null) {
            aVar.cancel();
        }
        this.f20102g.setText(R.string.pb_video_next_video);
        this.j.setProgress(0);
    }

    public void setDate(a2 a2Var) {
        if (a2Var == null || a2Var.u1() == null) {
            return;
        }
        this.f20101f.W(a2Var.u1().thumbnail_url, 10, false);
        this.f20102g.setText(R.string.pb_video_next_play);
        this.f20103h.setText(a2Var.x1());
        this.j.setProgress(0);
    }

    public void setIsCountDownValid(boolean z) {
        if (this.k != z) {
            this.k = z;
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
        super.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
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

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20100e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20100e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }
}
