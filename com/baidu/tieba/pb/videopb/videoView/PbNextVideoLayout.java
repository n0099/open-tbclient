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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int lvV;
    private int lvW;
    private TbImageView lvX;
    private TextView lvY;
    private TextView lvZ;
    private ImageView lwa;
    private ProgressBar lwb;
    private boolean lwc;
    public boolean lwd;
    private a lwe;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.lvV = 5000;
        this.lvW = 50;
        this.lwc = true;
        this.lwd = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lvV = 5000;
        this.lvW = 50;
        this.lwc = true;
        this.lwd = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lvV = 5000;
        this.lvW = 50;
        this.lwc = true;
        this.lwd = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.lvX = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.lvY = (TextView) findViewById(R.id.pb_next_video_txt);
        this.lvZ = (TextView) findViewById(R.id.pb_next_video_title);
        this.lwa = (ImageView) findViewById(R.id.pb_next_video_close);
        this.lwb = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bmU().a(this.lwa, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void as(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.lvX.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.lvZ.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.lvZ.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.lwa.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.lwa.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.lvW = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bw bwVar) {
        if (bwVar != null && bwVar.biz() != null) {
            this.lvX.startLoad(bwVar.biz().thumbnail_url, 10, false);
            this.lvY.setText(R.string.pb_video_next_play);
            this.lvZ.setText(bwVar.getTitle());
            this.lwb.setProgress(0);
        }
    }

    private void stopProgress() {
        this.lwc = false;
        if (this.lwe != null) {
            this.lwe.cancel();
        }
        this.lvY.setText(R.string.pb_video_next_video);
        this.lwb.setProgress(0);
    }

    private void dmu() {
        this.lwc = true;
        this.lvY.setText(R.string.pb_video_next_play);
        if (this.lwe != null) {
            this.lwe.cancel();
        }
        this.lwe = new a(5000 - this.lwb.getProgress(), this.lvW);
        this.lwe.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.lwc != z) {
            this.lwc = z;
            if (getVisibility() == 0) {
                if (z) {
                    dmu();
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
            if (this.lwc) {
                dmu();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.lwb.setProgress(0);
        if (this.lwe != null) {
            this.lwe.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.lwa.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.lwd = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.lwb.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.lwd = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
