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
    private final int kef;
    private int keg;
    private TbImageView keh;
    private TextView kei;
    private TextView kej;
    private ImageView kek;
    private ProgressBar kel;
    private boolean kem;
    public boolean ken;
    private a keo;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.kef = 5000;
        this.keg = 50;
        this.kem = true;
        this.ken = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kef = 5000;
        this.keg = 50;
        this.kem = true;
        this.ken = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kef = 5000;
        this.keg = 50;
        this.kem = true;
        this.ken = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.keh = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.kei = (TextView) findViewById(R.id.pb_next_video_txt);
        this.kej = (TextView) findViewById(R.id.pb_next_video_title);
        this.kek = (ImageView) findViewById(R.id.pb_next_video_close);
        this.kel = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aUV().a(this.kek, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void al(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.keh.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.kej.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.kej.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kek.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kek.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.keg = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bk bkVar) {
        if (bkVar != null && bkVar.aQQ() != null) {
            this.keh.startLoad(bkVar.aQQ().thumbnail_url, 10, false);
            this.kei.setText(R.string.pb_video_next_play);
            this.kej.setText(bkVar.getTitle());
            this.kel.setProgress(0);
        }
    }

    private void stopProgress() {
        this.kem = false;
        if (this.keo != null) {
            this.keo.cancel();
        }
        this.kei.setText(R.string.pb_video_next_video);
        this.kel.setProgress(0);
    }

    private void cLL() {
        this.kem = true;
        this.kei.setText(R.string.pb_video_next_play);
        if (this.keo != null) {
            this.keo.cancel();
        }
        this.keo = new a(5000 - this.kel.getProgress(), this.keg);
        this.keo.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.kem != z) {
            this.kem = z;
            if (getVisibility() == 0) {
                if (z) {
                    cLL();
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
            if (this.kem) {
                cLL();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.kel.setProgress(0);
        if (this.keo != null) {
            this.keo.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.kek.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.ken = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.kel.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.ken = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
