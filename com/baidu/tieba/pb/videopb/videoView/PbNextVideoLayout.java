package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private ProgressBar mmA;
    private boolean mmB;
    public boolean mmC;
    private a mmD;
    private final int mmu;
    private int mmv;
    private TbImageView mmw;
    private TextView mmx;
    private TextView mmy;
    private ImageView mmz;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.mmu = 5000;
        this.mmv = 50;
        this.mmB = true;
        this.mmC = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mmu = 5000;
        this.mmv = 50;
        this.mmB = true;
        this.mmC = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mmu = 5000;
        this.mmv = 50;
        this.mmB = true;
        this.mmC = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.mmw = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.mmx = (TextView) findViewById(R.id.pb_next_video_txt);
        this.mmy = (TextView) findViewById(R.id.pb_next_video_title);
        this.mmz = (ImageView) findViewById(R.id.pb_next_video_close);
        this.mmA = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bsR().a(this.mmz, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void au(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.mmw.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.mmy.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.mmy.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.mmz.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.mmz.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.mmv = (!z2 || z) ? 50 : 25;
    }

    public void setDate(cb cbVar) {
        if (cbVar != null && cbVar.boh() != null) {
            this.mmw.startLoad(cbVar.boh().thumbnail_url, 10, false);
            this.mmx.setText(R.string.pb_video_next_play);
            this.mmy.setText(cbVar.getTitle());
            this.mmA.setProgress(0);
        }
    }

    private void se() {
        this.mmB = false;
        if (this.mmD != null) {
            this.mmD.cancel();
        }
        this.mmx.setText(R.string.pb_video_next_video);
        this.mmA.setProgress(0);
    }

    private void dvj() {
        this.mmB = true;
        this.mmx.setText(R.string.pb_video_next_play);
        if (this.mmD != null) {
            this.mmD.cancel();
        }
        this.mmD = new a(5000 - this.mmA.getProgress(), this.mmv);
        this.mmD.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.mmB != z) {
            this.mmB = z;
            if (getVisibility() == 0) {
                if (z) {
                    dvj();
                } else {
                    se();
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.mmB) {
                dvj();
                return;
            } else {
                se();
                return;
            }
        }
        this.mmA.setProgress(0);
        if (this.mmD != null) {
            this.mmD.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mmz.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.mmC = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.mmA.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.mmC = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
