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
    private final int jap;
    private int jaq;
    private TbImageView jar;
    private TextView jas;
    private TextView jat;
    private ImageView jau;
    private ProgressBar jav;
    private boolean jaw;
    public boolean jax;
    private a jay;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.jap = 5000;
        this.jaq = 50;
        this.jaw = true;
        this.jax = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jap = 5000;
        this.jaq = 50;
        this.jaw = true;
        this.jax = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jap = 5000;
        this.jaq = 50;
        this.jaw = true;
        this.jax = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.jar = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.jas = (TextView) findViewById(R.id.pb_next_video_txt);
        this.jat = (TextView) findViewById(R.id.pb_next_video_title);
        this.jau = (ImageView) findViewById(R.id.pb_next_video_close);
        this.jav = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aGA().a(this.jau, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void ah(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.jar.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.jat.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.jat.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jau.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jau.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.jaq = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.aCD() != null) {
            this.jar.startLoad(bjVar.aCD().thumbnail_url, 10, false);
            this.jas.setText(R.string.pb_video_next_play);
            this.jat.setText(bjVar.getTitle());
            this.jav.setProgress(0);
        }
    }

    private void stopProgress() {
        this.jaw = false;
        if (this.jay != null) {
            this.jay.cancel();
        }
        this.jas.setText(R.string.pb_video_next_video);
        this.jav.setProgress(0);
    }

    private void ctK() {
        this.jaw = true;
        this.jas.setText(R.string.pb_video_next_play);
        if (this.jay != null) {
            this.jay.cancel();
        }
        this.jay = new a(5000 - this.jav.getProgress(), this.jaq);
        this.jay.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.jaw != z) {
            this.jaw = z;
            if (getVisibility() == 0) {
                if (z) {
                    ctK();
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
            if (this.jaw) {
                ctK();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.jav.setProgress(0);
        if (this.jay != null) {
            this.jay.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.jau.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.jax = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.jav.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.jax = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
