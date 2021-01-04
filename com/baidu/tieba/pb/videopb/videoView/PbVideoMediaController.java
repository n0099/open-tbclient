package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
/* loaded from: classes2.dex */
public class PbVideoMediaController extends OperableVideoMediaControllerView {
    private ProgressBar miI;

    public PbVideoMediaController(Context context) {
        super(context);
        init();
    }

    public PbVideoMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PbVideoMediaController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.miI = (ProgressBar) findViewById(R.id.pb_bottom_progress_bar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    protected View fH(Context context) {
        return View.inflate(context, R.layout.pb_video_media_controller, null);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void bz(int i, int i2) {
        super.bz(i, i2);
        this.miI.setProgress(this.gjY.getProgress());
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void aUR() {
        super.aUR();
        this.miI.setProgress(0);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i, boolean z) {
        super.setCurrentDuration(i, z);
        if (!z) {
            this.gjY.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
            if (this.gjW != null) {
                this.gjW.setText(at.stringForVideoTime(i));
            }
        }
        this.miI.setProgress(this.gjY.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.VideoControllerView
    public int bPa() {
        int bPa = super.bPa();
        this.miI.setProgress(this.gjY.getProgress());
        return bPa;
    }

    public void setBottomBarShow(boolean z) {
        this.miI.setVisibility(z ? 0 : 8);
        this.gjY.setVisibility(z ? 8 : 0);
        this.gjW.setVisibility(z ? 8 : 0);
        this.gjX.setVisibility(z ? 8 : 0);
    }

    public void au(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds126);
        if (z2 && z) {
            dimens = l.getDimens(getContext(), R.dimen.tbds210);
        }
        layoutParams.height = dimens;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gjW.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gjX.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds78);
        layoutParams3.rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds150 : R.dimen.tbds184);
    }
}
