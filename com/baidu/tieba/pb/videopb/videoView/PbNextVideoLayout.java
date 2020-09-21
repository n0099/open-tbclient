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
/* loaded from: classes21.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int lgE;
    private int lgF;
    private TbImageView lgG;
    private TextView lgH;
    private TextView lgI;
    private ImageView lgJ;
    private ProgressBar lgK;
    private boolean lgL;
    public boolean lgM;
    private a lgN;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.lgE = 5000;
        this.lgF = 50;
        this.lgL = true;
        this.lgM = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lgE = 5000;
        this.lgF = 50;
        this.lgL = true;
        this.lgM = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lgE = 5000;
        this.lgF = 50;
        this.lgL = true;
        this.lgM = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.lgG = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.lgH = (TextView) findViewById(R.id.pb_next_video_txt);
        this.lgI = (TextView) findViewById(R.id.pb_next_video_title);
        this.lgJ = (ImageView) findViewById(R.id.pb_next_video_close);
        this.lgK = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bkl().a(this.lgJ, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void at(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.lgG.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.lgI.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.lgI.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.lgJ.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.lgJ.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.lgF = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bw bwVar) {
        if (bwVar != null && bwVar.bfQ() != null) {
            this.lgG.startLoad(bwVar.bfQ().thumbnail_url, 10, false);
            this.lgH.setText(R.string.pb_video_next_play);
            this.lgI.setText(bwVar.getTitle());
            this.lgK.setProgress(0);
        }
    }

    private void stopProgress() {
        this.lgL = false;
        if (this.lgN != null) {
            this.lgN.cancel();
        }
        this.lgH.setText(R.string.pb_video_next_video);
        this.lgK.setProgress(0);
    }

    private void diL() {
        this.lgL = true;
        this.lgH.setText(R.string.pb_video_next_play);
        if (this.lgN != null) {
            this.lgN.cancel();
        }
        this.lgN = new a(5000 - this.lgK.getProgress(), this.lgF);
        this.lgN.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.lgL != z) {
            this.lgL = z;
            if (getVisibility() == 0) {
                if (z) {
                    diL();
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
            if (this.lgL) {
                diL();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.lgK.setProgress(0);
        if (this.lgN != null) {
            this.lgN.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.lgJ.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.lgM = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.lgK.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.lgM = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
