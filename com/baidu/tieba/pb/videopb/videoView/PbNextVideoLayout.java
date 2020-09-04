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
/* loaded from: classes16.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int kXY;
    private int kXZ;
    private TbImageView kYa;
    private TextView kYb;
    private TextView kYc;
    private ImageView kYd;
    private ProgressBar kYe;
    private boolean kYf;
    public boolean kYg;
    private a kYh;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.kXY = 5000;
        this.kXZ = 50;
        this.kYf = true;
        this.kYg = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kXY = 5000;
        this.kXZ = 50;
        this.kYf = true;
        this.kYg = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kXY = 5000;
        this.kXZ = 50;
        this.kYf = true;
        this.kYg = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.kYa = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.kYb = (TextView) findViewById(R.id.pb_next_video_txt);
        this.kYc = (TextView) findViewById(R.id.pb_next_video_title);
        this.kYd = (ImageView) findViewById(R.id.pb_next_video_close);
        this.kYe = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bjq().a(this.kYd, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void ar(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.kYa.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.kYc.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.kYc.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.kYd.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.kYd.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.kXZ = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bw bwVar) {
        if (bwVar != null && bwVar.beW() != null) {
            this.kYa.startLoad(bwVar.beW().thumbnail_url, 10, false);
            this.kYb.setText(R.string.pb_video_next_play);
            this.kYc.setText(bwVar.getTitle());
            this.kYe.setProgress(0);
        }
    }

    private void stopProgress() {
        this.kYf = false;
        if (this.kYh != null) {
            this.kYh.cancel();
        }
        this.kYb.setText(R.string.pb_video_next_video);
        this.kYe.setProgress(0);
    }

    private void dfh() {
        this.kYf = true;
        this.kYb.setText(R.string.pb_video_next_play);
        if (this.kYh != null) {
            this.kYh.cancel();
        }
        this.kYh = new a(5000 - this.kYe.getProgress(), this.kXZ);
        this.kYh.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.kYf != z) {
            this.kYf = z;
            if (getVisibility() == 0) {
                if (z) {
                    dfh();
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
            if (this.kYf) {
                dfh();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.kYe.setProgress(0);
        if (this.kYh != null) {
            this.kYh.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.kYd.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.kYg = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.kYe.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.kYg = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
