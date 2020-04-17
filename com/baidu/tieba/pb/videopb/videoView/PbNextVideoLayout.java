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
    private final int jMl;
    private int jMm;
    private TbImageView jMn;
    private TextView jMo;
    private TextView jMp;
    private ImageView jMq;
    private ProgressBar jMr;
    private boolean jMs;
    public boolean jMt;
    private a jMu;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.jMl = 5000;
        this.jMm = 50;
        this.jMs = true;
        this.jMt = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMl = 5000;
        this.jMm = 50;
        this.jMs = true;
        this.jMt = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jMl = 5000;
        this.jMm = 50;
        this.jMs = true;
        this.jMt = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.jMn = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.jMo = (TextView) findViewById(R.id.pb_next_video_txt);
        this.jMp = (TextView) findViewById(R.id.pb_next_video_title);
        this.jMq = (ImageView) findViewById(R.id.pb_next_video_close);
        this.jMr = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aOU().a(this.jMq, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void ai(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.jMn.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.jMp.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.jMp.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jMq.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jMq.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.jMm = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.aKV() != null) {
            this.jMn.startLoad(bjVar.aKV().thumbnail_url, 10, false);
            this.jMo.setText(R.string.pb_video_next_play);
            this.jMp.setText(bjVar.getTitle());
            this.jMr.setProgress(0);
        }
    }

    private void stopProgress() {
        this.jMs = false;
        if (this.jMu != null) {
            this.jMu.cancel();
        }
        this.jMo.setText(R.string.pb_video_next_video);
        this.jMr.setProgress(0);
    }

    private void cEO() {
        this.jMs = true;
        this.jMo.setText(R.string.pb_video_next_play);
        if (this.jMu != null) {
            this.jMu.cancel();
        }
        this.jMu = new a(5000 - this.jMr.getProgress(), this.jMm);
        this.jMu.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.jMs != z) {
            this.jMs = z;
            if (getVisibility() == 0) {
                if (z) {
                    cEO();
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
            if (this.jMs) {
                cEO();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.jMr.setProgress(0);
        if (this.jMu != null) {
            this.jMu.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.jMq.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.jMt = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.jMr.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.jMt = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
