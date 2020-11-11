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
    private final int lOp;
    private int lOq;
    private TbImageView lOr;
    private TextView lOs;
    private TextView lOt;
    private ImageView lOu;
    private ProgressBar lOv;
    private boolean lOw;
    public boolean lOx;
    private a lOy;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.lOp = 5000;
        this.lOq = 50;
        this.lOw = true;
        this.lOx = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lOp = 5000;
        this.lOq = 50;
        this.lOw = true;
        this.lOx = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lOp = 5000;
        this.lOq = 50;
        this.lOw = true;
        this.lOx = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.lOr = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.lOs = (TextView) findViewById(R.id.pb_next_video_txt);
        this.lOt = (TextView) findViewById(R.id.pb_next_video_title);
        this.lOu = (ImageView) findViewById(R.id.pb_next_video_close);
        this.lOv = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.brn().a(this.lOu, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void av(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.lOr.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.lOt.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.lOt.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.lOu.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.lOu.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.lOq = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bw bwVar) {
        if (bwVar != null && bwVar.bmS() != null) {
            this.lOr.startLoad(bwVar.bmS().thumbnail_url, 10, false);
            this.lOs.setText(R.string.pb_video_next_play);
            this.lOt.setText(bwVar.getTitle());
            this.lOv.setProgress(0);
        }
    }

    private void stopProgress() {
        this.lOw = false;
        if (this.lOy != null) {
            this.lOy.cancel();
        }
        this.lOs.setText(R.string.pb_video_next_video);
        this.lOv.setProgress(0);
    }

    private void dse() {
        this.lOw = true;
        this.lOs.setText(R.string.pb_video_next_play);
        if (this.lOy != null) {
            this.lOy.cancel();
        }
        this.lOy = new a(5000 - this.lOv.getProgress(), this.lOq);
        this.lOy.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.lOw != z) {
            this.lOw = z;
            if (getVisibility() == 0) {
                if (z) {
                    dse();
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
            if (this.lOw) {
                dse();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.lOv.setProgress(0);
        if (this.lOy != null) {
            this.lOy.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.lOu.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.lOx = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.lOv.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.lOx = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
