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
    private final int kIc;
    private int kId;
    private TbImageView kIe;
    private TextView kIf;
    private TextView kIg;
    private ImageView kIh;
    private ProgressBar kIi;
    private boolean kIj;
    public boolean kIk;
    private a kIl;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.kIc = 5000;
        this.kId = 50;
        this.kIj = true;
        this.kIk = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIc = 5000;
        this.kId = 50;
        this.kIj = true;
        this.kIk = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIc = 5000;
        this.kId = 50;
        this.kIj = true;
        this.kIk = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.kIe = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.kIf = (TextView) findViewById(R.id.pb_next_video_txt);
        this.kIg = (TextView) findViewById(R.id.pb_next_video_title);
        this.kIh = (ImageView) findViewById(R.id.pb_next_video_close);
        this.kIi = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.baR().a(this.kIh, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void an(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.kIe.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.kIg.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.kIg.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.kIh.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.kIh.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.kId = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bv bvVar) {
        if (bvVar != null && bvVar.aWD() != null) {
            this.kIe.startLoad(bvVar.aWD().thumbnail_url, 10, false);
            this.kIf.setText(R.string.pb_video_next_play);
            this.kIg.setText(bvVar.getTitle());
            this.kIi.setProgress(0);
        }
    }

    private void stopProgress() {
        this.kIj = false;
        if (this.kIl != null) {
            this.kIl.cancel();
        }
        this.kIf.setText(R.string.pb_video_next_video);
        this.kIi.setProgress(0);
    }

    private void cUj() {
        this.kIj = true;
        this.kIf.setText(R.string.pb_video_next_play);
        if (this.kIl != null) {
            this.kIl.cancel();
        }
        this.kIl = new a(5000 - this.kIi.getProgress(), this.kId);
        this.kIl.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.kIj != z) {
            this.kIj = z;
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
            if (this.kIj) {
                cUj();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.kIi.setProgress(0);
        if (this.kIl != null) {
            this.kIl.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.kIh.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.kIk = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.kIi.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.kIk = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
