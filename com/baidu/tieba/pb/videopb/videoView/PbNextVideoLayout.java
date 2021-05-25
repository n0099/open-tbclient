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
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
/* loaded from: classes5.dex */
public class PbNextVideoLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f19494e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f19495f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19496g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19497h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19498i;
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
        this.f19494e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }

    public void b(boolean z, boolean z2) {
        getLayoutParams().height = l.g(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.f19495f.getLayoutParams().width = l.g(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.f19497h.setTextSize(0, l.g(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.f19497h.getLayoutParams()).topMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.f19498i.getLayoutParams()).topMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.f19498i.getLayoutParams()).rightMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.f19494e = (!z2 || z) ? 50 : 25;
    }

    public final void c(Context context) {
        RelativeLayout.inflate(context, R.layout.pb_next_video_layout, this);
        this.f19495f = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.f19496g = (TextView) findViewById(R.id.pb_next_video_txt);
        this.f19497h = (TextView) findViewById(R.id.pb_next_video_title);
        this.f19498i = (ImageView) findViewById(R.id.pb_next_video_close);
        this.j = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19498i, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, null);
    }

    public final void d() {
        this.k = true;
        this.f19496g.setText(R.string.pb_video_next_play);
        a aVar = this.m;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(5000 - this.j.getProgress(), this.f19494e);
        this.m = aVar2;
        aVar2.start();
    }

    public final void e() {
        this.k = false;
        a aVar = this.m;
        if (aVar != null) {
            aVar.cancel();
        }
        this.f19496g.setText(R.string.pb_video_next_video);
        this.j.setProgress(0);
    }

    public void setDate(a2 a2Var) {
        if (a2Var == null || a2Var.w1() == null) {
            return;
        }
        this.f19495f.V(a2Var.w1().thumbnail_url, 10, false);
        this.f19496g.setText(R.string.pb_video_next_play);
        this.f19497h.setText(a2Var.z1());
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
        this.f19498i.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
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

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19494e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19494e = 50;
        this.k = true;
        this.l = true;
        c(context);
    }
}
