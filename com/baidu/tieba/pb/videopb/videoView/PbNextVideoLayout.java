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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbNextVideoLayout extends RelativeLayout {
    private final int kza;
    private int kzb;
    private TbImageView kzc;
    private TextView kzd;
    private TextView kze;
    private ImageView kzf;
    private ProgressBar kzg;
    private boolean kzh;
    public boolean kzi;
    private a kzj;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.kza = 5000;
        this.kzb = 50;
        this.kzh = true;
        this.kzi = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kza = 5000;
        this.kzb = 50;
        this.kzh = true;
        this.kzi = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kza = 5000;
        this.kzb = 50;
        this.kzh = true;
        this.kzi = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.kzc = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.kzd = (TextView) findViewById(R.id.pb_next_video_txt);
        this.kze = (TextView) findViewById(R.id.pb_next_video_title);
        this.kzf = (ImageView) findViewById(R.id.pb_next_video_close);
        this.kzg = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.aWQ().a(this.kzf, R.drawable.icon_pure_close16_n_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void am(boolean z, boolean z2) {
        int i = R.dimen.tbds52;
        int i2 = R.dimen.tbds42;
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.kzc.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.kze.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.kze.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kzf.getLayoutParams();
        Context context = getContext();
        if (!z2 || z) {
            i2 = R.dimen.tbds20;
        }
        layoutParams.topMargin = l.getDimens(context, i2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kzf.getLayoutParams();
        Context context2 = getContext();
        if (!z2 || z) {
            i = R.dimen.tbds44;
        }
        layoutParams2.rightMargin = l.getDimens(context2, i);
        this.kzb = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bu buVar) {
        if (buVar != null && buVar.aSH() != null) {
            this.kzc.startLoad(buVar.aSH().thumbnail_url, 10, false);
            this.kzd.setText(R.string.pb_video_next_play);
            this.kze.setText(buVar.getTitle());
            this.kzg.setProgress(0);
        }
    }

    private void stopProgress() {
        this.kzh = false;
        if (this.kzj != null) {
            this.kzj.cancel();
        }
        this.kzd.setText(R.string.pb_video_next_video);
        this.kzg.setProgress(0);
    }

    private void cQt() {
        this.kzh = true;
        this.kzd.setText(R.string.pb_video_next_play);
        if (this.kzj != null) {
            this.kzj.cancel();
        }
        this.kzj = new a(5000 - this.kzg.getProgress(), this.kzb);
        this.kzj.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.kzh != z) {
            this.kzh = z;
            if (getVisibility() == 0) {
                if (z) {
                    cQt();
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
            if (this.kzh) {
                cQt();
                return;
            } else {
                stopProgress();
                return;
            }
        }
        this.kzg.setProgress(0);
        if (this.kzj != null) {
            this.kzj.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.kzf.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.kzi = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.kzg.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.kzi = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
