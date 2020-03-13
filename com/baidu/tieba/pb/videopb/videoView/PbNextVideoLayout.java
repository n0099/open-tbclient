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
    private final int jaD;
    private int jaE;
    private TbImageView jaF;
    private TextView jaG;
    private TextView jaH;
    private ImageView jaI;
    private ProgressBar jaJ;
    private boolean jaK;
    public boolean jaL;
    private a jaM;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.jaD = 5000;
        this.jaE = 50;
        this.jaK = true;
        this.jaL = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jaD = 5000;
        this.jaE = 50;
        this.jaK = true;
        this.jaL = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jaD = 5000;
        this.jaE = 50;
        this.jaK = true;
        this.jaL = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.jaF = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.jaG = (TextView) findViewById(R.id.pb_next_video_txt);
        this.jaH = (TextView) findViewById(R.id.pb_next_video_title);
        this.jaI = (ImageView) findViewById(R.id.pb_next_video_close);
        this.jaJ = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aGC().a(this.jaI, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void ah(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.jaF.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.jaH.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.jaH.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jaI.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jaI.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.jaE = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.aCF() != null) {
            this.jaF.startLoad(bjVar.aCF().thumbnail_url, 10, false);
            this.jaG.setText(R.string.pb_video_next_play);
            this.jaH.setText(bjVar.getTitle());
            this.jaJ.setProgress(0);
        }
    }

    private void stopProgress() {
        this.jaK = false;
        if (this.jaM != null) {
            this.jaM.cancel();
        }
        this.jaG.setText(R.string.pb_video_next_video);
        this.jaJ.setProgress(0);
    }

    private void ctN() {
        this.jaK = true;
        this.jaG.setText(R.string.pb_video_next_play);
        if (this.jaM != null) {
            this.jaM.cancel();
        }
        this.jaM = new a(5000 - this.jaJ.getProgress(), this.jaE);
        this.jaM.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.jaK != z) {
            this.jaK = z;
            if (getVisibility() == 0) {
                if (z) {
                    ctN();
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
            if (this.jaK) {
                ctN();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.jaJ.setProgress(0);
        if (this.jaM != null) {
            this.jaM.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.jaI.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.jaL = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.jaJ.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.jaL = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
