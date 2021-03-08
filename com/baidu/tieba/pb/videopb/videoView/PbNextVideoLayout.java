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
    private final int moM;
    private int moN;
    private TbImageView moO;
    private TextView moP;
    private TextView moQ;
    private ImageView moR;
    private ProgressBar moS;
    private boolean moT;
    public boolean moU;
    private a moV;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.moM = 5000;
        this.moN = 50;
        this.moT = true;
        this.moU = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.moM = 5000;
        this.moN = 50;
        this.moT = true;
        this.moU = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.moM = 5000;
        this.moN = 50;
        this.moT = true;
        this.moU = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.moO = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.moP = (TextView) findViewById(R.id.pb_next_video_txt);
        this.moQ = (TextView) findViewById(R.id.pb_next_video_title);
        this.moR = (ImageView) findViewById(R.id.pb_next_video_close);
        this.moS = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bsU().a(this.moR, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void au(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.moO.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.moQ.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.moQ.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.moR.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.moR.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.moN = (!z2 || z) ? 50 : 25;
    }

    public void setDate(cb cbVar) {
        if (cbVar != null && cbVar.boj() != null) {
            this.moO.startLoad(cbVar.boj().thumbnail_url, 10, false);
            this.moP.setText(R.string.pb_video_next_play);
            this.moQ.setText(cbVar.getTitle());
            this.moS.setProgress(0);
        }
    }

    private void se() {
        this.moT = false;
        if (this.moV != null) {
            this.moV.cancel();
        }
        this.moP.setText(R.string.pb_video_next_video);
        this.moS.setProgress(0);
    }

    private void dvz() {
        this.moT = true;
        this.moP.setText(R.string.pb_video_next_play);
        if (this.moV != null) {
            this.moV.cancel();
        }
        this.moV = new a(5000 - this.moS.getProgress(), this.moN);
        this.moV.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.moT != z) {
            this.moT = z;
            if (getVisibility() == 0) {
                if (z) {
                    dvz();
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
            if (this.moT) {
                dvz();
                return;
            } else {
                se();
                return;
            }
        }
        this.moS.setProgress(0);
        if (this.moV != null) {
            this.moV.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.moR.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.moU = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.moS.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.moU = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
