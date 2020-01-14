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
/* loaded from: classes7.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int iYO;
    private int iYP;
    private TbImageView iYQ;
    private TextView iYR;
    private TextView iYS;
    private ImageView iYT;
    private ProgressBar iYU;
    private boolean iYV;
    public boolean iYW;
    private a iYX;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.iYO = 5000;
        this.iYP = 50;
        this.iYV = true;
        this.iYW = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iYO = 5000;
        this.iYP = 50;
        this.iYV = true;
        this.iYW = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iYO = 5000;
        this.iYP = 50;
        this.iYV = true;
        this.iYW = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.iYQ = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.iYR = (TextView) findViewById(R.id.pb_next_video_txt);
        this.iYS = (TextView) findViewById(R.id.pb_next_video_title);
        this.iYT = (ImageView) findViewById(R.id.pb_next_video_close);
        this.iYU = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aEp().a(this.iYT, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void af(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.iYQ.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.iYS.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.iYS.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iYT.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iYT.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.iYP = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.aAo() != null) {
            this.iYQ.startLoad(bjVar.aAo().thumbnail_url, 10, false);
            this.iYR.setText(R.string.pb_video_next_play);
            this.iYS.setText(bjVar.getTitle());
            this.iYU.setProgress(0);
        }
    }

    private void stopProgress() {
        this.iYV = false;
        if (this.iYX != null) {
            this.iYX.cancel();
        }
        this.iYR.setText(R.string.pb_video_next_video);
        this.iYU.setProgress(0);
    }

    private void csr() {
        this.iYV = true;
        this.iYR.setText(R.string.pb_video_next_play);
        if (this.iYX != null) {
            this.iYX.cancel();
        }
        this.iYX = new a(5000 - this.iYU.getProgress(), this.iYP);
        this.iYX.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.iYV != z) {
            this.iYV = z;
            if (getVisibility() == 0) {
                if (z) {
                    csr();
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
            if (this.iYV) {
                csr();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.iYU.setProgress(0);
        if (this.iYX != null) {
            this.iYX.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.iYT.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.iYW = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.iYU.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.iYW = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
