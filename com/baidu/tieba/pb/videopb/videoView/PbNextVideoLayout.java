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
    private a mdA;
    private final int mdr;
    private int mds;
    private TbImageView mdt;
    private TextView mdu;
    private TextView mdv;
    private ImageView mdw;
    private ProgressBar mdx;
    private boolean mdy;
    public boolean mdz;

    public PbNextVideoLayout(Context context) {
        super(context);
        this.mdr = 5000;
        this.mds = 50;
        this.mdy = true;
        this.mdz = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mdr = 5000;
        this.mds = 50;
        this.mdy = true;
        this.mdz = true;
        init(context);
    }

    public PbNextVideoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mdr = 5000;
        this.mds = 50;
        this.mdy = true;
        this.mdz = true;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_next_video_layout, this);
        this.mdt = (TbImageView) findViewById(R.id.pb_next_video_img);
        this.mdu = (TextView) findViewById(R.id.pb_next_video_txt);
        this.mdv = (TextView) findViewById(R.id.pb_next_video_title);
        this.mdw = (ImageView) findViewById(R.id.pb_next_video_close);
        this.mdx = (ProgressBar) findViewById(R.id.pb_next_video_progress_bar);
        SvgManager.bsx().a(this.mdw, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void au(boolean z, boolean z2) {
        getLayoutParams().height = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds156 : R.dimen.tbds267);
        this.mdt.getLayoutParams().width = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds276 : R.dimen.tbds470);
        this.mdv.setTextSize(0, l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds42 : R.dimen.tbds52));
        ((LinearLayout.LayoutParams) this.mdv.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds8 : R.dimen.tbds22);
        ((RelativeLayout.LayoutParams) this.mdw.getLayoutParams()).topMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds20 : R.dimen.tbds42);
        ((RelativeLayout.LayoutParams) this.mdw.getLayoutParams()).rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds52);
        this.mds = (!z2 || z) ? 50 : 25;
    }

    public void setDate(bz bzVar) {
        if (bzVar != null && bzVar.bnO() != null) {
            this.mdt.startLoad(bzVar.bnO().thumbnail_url, 10, false);
            this.mdu.setText(R.string.pb_video_next_play);
            this.mdv.setText(bzVar.getTitle());
            this.mdx.setProgress(0);
        }
    }

    private void sh() {
        this.mdy = false;
        if (this.mdA != null) {
            this.mdA.cancel();
        }
        this.mdu.setText(R.string.pb_video_next_video);
        this.mdx.setProgress(0);
    }

    private void dsW() {
        this.mdy = true;
        this.mdu.setText(R.string.pb_video_next_play);
        if (this.mdA != null) {
            this.mdA.cancel();
        }
        this.mdA = new a(5000 - this.mdx.getProgress(), this.mds);
        this.mdA.start();
    }

    public void setIsCountDownValid(boolean z) {
        if (this.mdy != z) {
            this.mdy = z;
            if (getVisibility() == 0) {
                if (z) {
                    dsW();
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
            if (this.mdy) {
                dsW();
                return;
            } else {
                sh();
                return;
            }
        }
        this.mdx.setProgress(0);
        if (this.mdA != null) {
            this.mdA.cancel();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mdw.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
            PbNextVideoLayout.this.mdz = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbNextVideoLayout.this.mdx.setProgress(((int) (5000 - j)) * 2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbNextVideoLayout.this.mdz = false;
            PbNextVideoLayout.this.performClick();
        }
    }
}
