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
    private final int jMp;
    private int jMq;
    private TbImageView jMr;
    private TextView jMs;
    private TextView jMt;
    private ImageView jMu;
    private ProgressBar jMv;
    private boolean jMw;
    public boolean jMx;
    private a jMy;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.jMp = 5000;
        this.jMq = 50;
        this.jMw = true;
        this.jMx = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMp = 5000;
        this.jMq = 50;
        this.jMw = true;
        this.jMx = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jMp = 5000;
        this.jMq = 50;
        this.jMw = true;
        this.jMx = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.jMr = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.jMs = (TextView) findViewById(R.id.pb_next_video_txt);
        this.jMt = (TextView) findViewById(R.id.pb_next_video_title);
        this.jMu = (ImageView) findViewById(R.id.pb_next_video_close);
        this.jMv = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aOR().a(this.jMu, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void ai(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.jMr.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.jMt.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.jMt.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jMu.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jMu.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.jMq = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.aKT() != null) {
            this.jMr.startLoad(bjVar.aKT().thumbnail_url, 10, false);
            this.jMs.setText(R.string.pb_video_next_play);
            this.jMt.setText(bjVar.getTitle());
            this.jMv.setProgress(0);
        }
    }

    private void stopProgress() {
        this.jMw = false;
        if (this.jMy != null) {
            this.jMy.cancel();
        }
        this.jMs.setText(R.string.pb_video_next_video);
        this.jMv.setProgress(0);
    }

    private void cEM() {
        this.jMw = true;
        this.jMs.setText(R.string.pb_video_next_play);
        if (this.jMy != null) {
            this.jMy.cancel();
        }
        this.jMy = new a(5000 - this.jMv.getProgress(), this.jMq);
        this.jMy.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.jMw != z) {
            this.jMw = z;
            if (getVisibility() == 0) {
                if (z) {
                    cEM();
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
            if (this.jMw) {
                cEM();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.jMv.setProgress(0);
        if (this.jMy != null) {
            this.jMy.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.jMu.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.jMx = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.jMv.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.jMx = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
