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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int kIe;
    private int kIf;
    private TbImageView kIg;
    private TextView kIh;
    private TextView kIi;
    private ImageView kIj;
    private ProgressBar kIk;
    private boolean kIl;
    public boolean kIm;
    private a kIn;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.kIe = 5000;
        this.kIf = 50;
        this.kIl = true;
        this.kIm = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIe = 5000;
        this.kIf = 50;
        this.kIl = true;
        this.kIm = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIe = 5000;
        this.kIf = 50;
        this.kIl = true;
        this.kIm = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.kIg = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.kIh = (TextView) findViewById(R.id.pb_next_video_txt);
        this.kIi = (TextView) findViewById(R.id.pb_next_video_title);
        this.kIj = (ImageView) findViewById(R.id.pb_next_video_close);
        this.kIk = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.baR().a(this.kIj, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void an(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.kIg.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.kIi.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.kIi.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.kIj.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.kIj.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.kIf = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bv bvVar) {
        if (bvVar != null && bvVar.aWD() != null) {
            this.kIg.startLoad(bvVar.aWD().thumbnail_url, 10, false);
            this.kIh.setText(R.string.pb_video_next_play);
            this.kIi.setText(bvVar.getTitle());
            this.kIk.setProgress(0);
        }
    }

    private void stopProgress() {
        this.kIl = false;
        if (this.kIn != null) {
            this.kIn.cancel();
        }
        this.kIh.setText(R.string.pb_video_next_video);
        this.kIk.setProgress(0);
    }

    private void cUj() {
        this.kIl = true;
        this.kIh.setText(R.string.pb_video_next_play);
        if (this.kIn != null) {
            this.kIn.cancel();
        }
        this.kIn = new a(5000 - this.kIk.getProgress(), this.kIf);
        this.kIn.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.kIl != z) {
            this.kIl = z;
            if (getVisibility() == 0) {
                if (z) {
                    cUj();
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
            if (this.kIl) {
                cUj();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.kIk.setProgress(0);
        if (this.kIn != null) {
            this.kIn.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.kIj.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.kIm = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.kIk.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.kIm = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
