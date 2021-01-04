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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int mhX;
    private int mhY;
    private TbImageView mhZ;
    private TextView mia;
    private TextView mib;
    private ImageView mic;
    private ProgressBar mie;
    private boolean mif;
    public boolean mig;
    private a mih;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.mhX = 5000;
        this.mhY = 50;
        this.mif = true;
        this.mig = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mhX = 5000;
        this.mhY = 50;
        this.mif = true;
        this.mig = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mhX = 5000;
        this.mhY = 50;
        this.mif = true;
        this.mig = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.mhZ = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.mia = (TextView) findViewById(R.id.pb_next_video_txt);
        this.mib = (TextView) findViewById(R.id.pb_next_video_title);
        this.mic = (ImageView) findViewById(R.id.pb_next_video_close);
        this.mie = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bwq().a(this.mic, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void au(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.mhZ.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.mib.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.mib.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.mic.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.mic.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.mhY = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bz bzVar) {
        if (bzVar != null && bzVar.brH() != null) {
            this.mhZ.startLoad(bzVar.brH().thumbnail_url, 10, false);
            this.mia.setText(R.string.pb_video_next_play);
            this.mib.setText(bzVar.getTitle());
            this.mie.setProgress(0);
        }
    }

    private void sh() {
        this.mif = false;
        if (this.mih != null) {
            this.mih.cancel();
        }
        this.mia.setText(R.string.pb_video_next_video);
        this.mie.setProgress(0);
    }

    private void dwN() {
        this.mif = true;
        this.mia.setText(R.string.pb_video_next_play);
        if (this.mih != null) {
            this.mih.cancel();
        }
        this.mih = new a(5000 - this.mie.getProgress(), this.mhY);
        this.mih.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.mif != z) {
            this.mif = z;
            if (getVisibility() == 0) {
                if (z) {
                    dwN();
                } else {
                    sh();
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.mif) {
                dwN();
                return;
            } else {
                sh();
                return;
            }
        }
        this.mie.setProgress(0);
        if (this.mih != null) {
            this.mih.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mic.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.mig = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.mie.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.mig = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
