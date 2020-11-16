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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int lOF;
    private int lOG;
    private TbImageView lOH;
    private TextView lOI;
    private TextView lOJ;
    private ImageView lOK;
    private ProgressBar lOL;
    private boolean lOM;
    public boolean lON;
    private a lOO;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.lOF = 5000;
        this.lOG = 50;
        this.lOM = true;
        this.lON = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lOF = 5000;
        this.lOG = 50;
        this.lOM = true;
        this.lON = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lOF = 5000;
        this.lOG = 50;
        this.lOM = true;
        this.lON = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.lOH = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.lOI = (TextView) findViewById(R.id.pb_next_video_txt);
        this.lOJ = (TextView) findViewById(R.id.pb_next_video_title);
        this.lOK = (ImageView) findViewById(R.id.pb_next_video_close);
        this.lOL = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bqB().a(this.lOK, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void as(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.lOH.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.lOJ.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.lOJ.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.lOK.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.lOK.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.lOG = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bx bxVar) {
        if (bxVar != null && bxVar.blU() != null) {
            this.lOH.startLoad(bxVar.blU().thumbnail_url, 10, false);
            this.lOI.setText(R.string.pb_video_next_play);
            this.lOJ.setText(bxVar.getTitle());
            this.lOL.setProgress(0);
        }
    }

    private void stopProgress() {
        this.lOM = false;
        if (this.lOO != null) {
            this.lOO.cancel();
        }
        this.lOI.setText(R.string.pb_video_next_video);
        this.lOL.setProgress(0);
    }

    private void drE() {
        this.lOM = true;
        this.lOI.setText(R.string.pb_video_next_play);
        if (this.lOO != null) {
            this.lOO.cancel();
        }
        this.lOO = new a(5000 - this.lOL.getProgress(), this.lOG);
        this.lOO.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.lOM != z) {
            this.lOM = z;
            if (getVisibility() == 0) {
                if (z) {
                    drE();
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
            if (this.lOM) {
                drE();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.lOL.setProgress(0);
        if (this.lOO != null) {
            this.lOO.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.lOK.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.lON = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.lOL.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.lON = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
