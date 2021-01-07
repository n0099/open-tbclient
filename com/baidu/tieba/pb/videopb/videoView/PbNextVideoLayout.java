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
    private final int mhW;
    private int mhX;
    private TbImageView mhY;
    private TextView mhZ;
    private TextView mia;
    private ImageView mib;
    private ProgressBar mic;
    private boolean mie;
    public boolean mif;
    private a mig;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.mhW = 5000;
        this.mhX = 50;
        this.mie = true;
        this.mif = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mhW = 5000;
        this.mhX = 50;
        this.mie = true;
        this.mif = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mhW = 5000;
        this.mhX = 50;
        this.mie = true;
        this.mif = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.mhY = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.mhZ = (TextView) findViewById(R.id.pb_next_video_txt);
        this.mia = (TextView) findViewById(R.id.pb_next_video_title);
        this.mib = (ImageView) findViewById(R.id.pb_next_video_close);
        this.mic = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bwr().a(this.mib, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void au(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.mhY.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.mia.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.mia.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.mib.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.mib.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.mhX = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bz bzVar) {
        if (bzVar != null && bzVar.brI() != null) {
            this.mhY.startLoad(bzVar.brI().thumbnail_url, 10, false);
            this.mhZ.setText(R.string.pb_video_next_play);
            this.mia.setText(bzVar.getTitle());
            this.mic.setProgress(0);
        }
    }

    private void sh() {
        this.mie = false;
        if (this.mig != null) {
            this.mig.cancel();
        }
        this.mhZ.setText(R.string.pb_video_next_video);
        this.mic.setProgress(0);
    }

    private void dwO() {
        this.mie = true;
        this.mhZ.setText(R.string.pb_video_next_play);
        if (this.mig != null) {
            this.mig.cancel();
        }
        this.mig = new a(5000 - this.mic.getProgress(), this.mhX);
        this.mig.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.mie != z) {
            this.mie = z;
            if (getVisibility() == 0) {
                if (z) {
                    dwO();
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
            if (this.mie) {
                dwO();
                return;
            } else {
                sh();
                return;
            }
        }
        this.mic.setProgress(0);
        if (this.mig != null) {
            this.mig.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mib.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.mif = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.mic.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.mif = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
