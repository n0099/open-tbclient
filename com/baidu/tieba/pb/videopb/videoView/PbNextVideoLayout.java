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
    private boolean lIA;
    public boolean lIB;
    private a lIC;
    private final int lIt;
    private int lIu;
    private TbImageView lIv;
    private TextView lIw;
    private TextView lIx;
    private ImageView lIy;
    private ProgressBar lIz;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.lIt = 5000;
        this.lIu = 50;
        this.lIA = true;
        this.lIB = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lIt = 5000;
        this.lIu = 50;
        this.lIA = true;
        this.lIB = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lIt = 5000;
        this.lIu = 50;
        this.lIA = true;
        this.lIB = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.lIv = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.lIw = (TextView) findViewById(R.id.pb_next_video_txt);
        this.lIx = (TextView) findViewById(R.id.pb_next_video_title);
        this.lIy = (ImageView) findViewById(R.id.pb_next_video_close);
        this.lIz = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.boN().a(this.lIy, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void av(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.lIv.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.lIx.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.lIx.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.lIy.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.lIy.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.lIu = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bw bwVar) {
        if (bwVar != null && bwVar.bks() != null) {
            this.lIv.startLoad(bwVar.bks().thumbnail_url, 10, false);
            this.lIw.setText(R.string.pb_video_next_play);
            this.lIx.setText(bwVar.getTitle());
            this.lIz.setProgress(0);
        }
    }

    private void stopProgress() {
        this.lIA = false;
        if (this.lIC != null) {
            this.lIC.cancel();
        }
        this.lIw.setText(R.string.pb_video_next_video);
        this.lIz.setProgress(0);
    }

    private void dpC() {
        this.lIA = true;
        this.lIw.setText(R.string.pb_video_next_play);
        if (this.lIC != null) {
            this.lIC.cancel();
        }
        this.lIC = new a(5000 - this.lIz.getProgress(), this.lIu);
        this.lIC.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.lIA != z) {
            this.lIA = z;
            if (getVisibility() == 0) {
                if (z) {
                    dpC();
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
            if (this.lIA) {
                dpC();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.lIz.setProgress(0);
        if (this.lIC != null) {
            this.lIC.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.lIy.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.lIB = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.lIz.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.lIB = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
