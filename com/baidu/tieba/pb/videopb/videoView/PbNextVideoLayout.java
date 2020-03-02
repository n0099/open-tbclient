package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private a jaA;
    private final int jar;
    private int jas;
    private TbImageView jat;
    private TextView jau;
    private TextView jav;
    private ImageView jaw;
    private ProgressBar jax;
    private boolean jay;
    public boolean jaz;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.jar = 5000;
        this.jas = 50;
        this.jay = true;
        this.jaz = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jar = 5000;
        this.jas = 50;
        this.jay = true;
        this.jaz = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jar = 5000;
        this.jas = 50;
        this.jay = true;
        this.jaz = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.jat = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.jau = (TextView) findViewById(R.id.pb_next_video_txt);
        this.jav = (TextView) findViewById(R.id.pb_next_video_title);
        this.jaw = (ImageView) findViewById(R.id.pb_next_video_close);
        this.jax = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aGC().a(this.jaw, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void ah(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.jat.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.jav.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.jav.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jaw.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jaw.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.jas = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.aCF() != null) {
            this.jat.startLoad(bjVar.aCF().thumbnail_url, 10, false);
            this.jau.setText(R.string.pb_video_next_play);
            this.jav.setText(bjVar.getTitle());
            this.jax.setProgress(0);
        }
    }

    private void stopProgress() {
        this.jay = false;
        if (this.jaA != null) {
            this.jaA.cancel();
        }
        this.jau.setText(R.string.pb_video_next_video);
        this.jax.setProgress(0);
    }

    private void ctM() {
        this.jay = true;
        this.jau.setText(R.string.pb_video_next_play);
        if (this.jaA != null) {
            this.jaA.cancel();
        }
        this.jaA = new a(5000 - this.jax.getProgress(), this.jas);
        this.jaA.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.jay != z) {
            this.jay = z;
            if (getVisibility() == 0) {
                if (z) {
                    ctM();
                } else {
                    stopProgress();
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.jay) {
                ctM();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.jax.setProgress(0);
        if (this.jaA != null) {
            this.jaA.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.jaw.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.jaz = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.jax.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.jaz = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
