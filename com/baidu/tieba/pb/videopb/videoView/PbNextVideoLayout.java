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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int kfm;
    private int kfn;
    private TbImageView kfo;
    private TextView kfp;
    private TextView kfq;
    private ImageView kfr;
    private ProgressBar kfs;
    private boolean kft;
    public boolean kfu;
    private a kfv;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.kfm = 5000;
        this.kfn = 50;
        this.kft = true;
        this.kfu = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kfm = 5000;
        this.kfn = 50;
        this.kft = true;
        this.kfu = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kfm = 5000;
        this.kfn = 50;
        this.kft = true;
        this.kfu = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.kfo = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.kfp = (TextView) findViewById(R.id.pb_next_video_txt);
        this.kfq = (TextView) findViewById(R.id.pb_next_video_title);
        this.kfr = (ImageView) findViewById(R.id.pb_next_video_close);
        this.kfs = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aUW().a(this.kfr, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void al(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.kfo.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.kfq.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.kfq.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kfr.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kfr.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.kfn = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bk bkVar) {
        if (bkVar != null && bkVar.aQQ() != null) {
            this.kfo.startLoad(bkVar.aQQ().thumbnail_url, 10, false);
            this.kfp.setText(R.string.pb_video_next_play);
            this.kfq.setText(bkVar.getTitle());
            this.kfs.setProgress(0);
        }
    }

    private void stopProgress() {
        this.kft = false;
        if (this.kfv != null) {
            this.kfv.cancel();
        }
        this.kfp.setText(R.string.pb_video_next_video);
        this.kfs.setProgress(0);
    }

    private void cMb() {
        this.kft = true;
        this.kfp.setText(R.string.pb_video_next_play);
        if (this.kfv != null) {
            this.kfv.cancel();
        }
        this.kfv = new a(5000 - this.kfs.getProgress(), this.kfn);
        this.kfv.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.kft != z) {
            this.kft = z;
            if (getVisibility() == 0) {
                if (z) {
                    cMb();
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
            if (this.kft) {
                cMb();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.kfs.setProgress(0);
        if (this.kfv != null) {
            this.kfv.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.kfr.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.kfu = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.kfs.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.kfu = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
