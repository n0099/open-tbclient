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
/* loaded from: classes6.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int iVg;
    private int iVh;
    private TbImageView iVi;
    private TextView iVj;
    private TextView iVk;
    private ImageView iVl;
    private ProgressBar iVm;
    private boolean iVn;
    public boolean iVo;
    private a iVp;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.iVg = 5000;
        this.iVh = 50;
        this.iVn = true;
        this.iVo = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVg = 5000;
        this.iVh = 50;
        this.iVn = true;
        this.iVo = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVg = 5000;
        this.iVh = 50;
        this.iVn = true;
        this.iVo = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.iVi = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.iVj = (TextView) findViewById(R.id.pb_next_video_txt);
        this.iVk = (TextView) findViewById(R.id.pb_next_video_title);
        this.iVl = (ImageView) findViewById(R.id.pb_next_video_close);
        this.iVm = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aDW().a(this.iVl, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void af(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.iVi.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.iVk.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.iVk.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iVl.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iVl.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.iVh = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bj bjVar) {
        if (bjVar != null && bjVar.azV() != null) {
            this.iVi.startLoad(bjVar.azV().thumbnail_url, 10, false);
            this.iVj.setText(R.string.pb_video_next_play);
            this.iVk.setText(bjVar.getTitle());
            this.iVm.setProgress(0);
        }
    }

    private void stopProgress() {
        this.iVn = false;
        if (this.iVp != null) {
            this.iVp.cancel();
        }
        this.iVj.setText(R.string.pb_video_next_video);
        this.iVm.setProgress(0);
    }

    private void cri() {
        this.iVn = true;
        this.iVj.setText(R.string.pb_video_next_play);
        if (this.iVp != null) {
            this.iVp.cancel();
        }
        this.iVp = new a(5000 - this.iVm.getProgress(), this.iVh);
        this.iVp.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.iVn != z) {
            this.iVn = z;
            if (getVisibility() == 0) {
                if (z) {
                    cri();
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
            if (this.iVn) {
                cri();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.iVm.setProgress(0);
        if (this.iVp != null) {
            this.iVp.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.iVl.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.iVo = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.iVm.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.iVo = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
