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
/* loaded from: classes21.dex */
public class PbVideoMediaController extends OperableVideoMediaControllerView {
    private ProgressBar lhn;

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
        this.lhn = (ProgressBar) findViewById(R.id.pb_bottom_progress_bar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    protected View eA(Context context) {
        return View.inflate(context, R.layout.pb_video_media_controller, null);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void bz(int i, int i2) {
        super.bz(i, i2);
        this.lhn.setProgress(this.fss.getProgress());
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void aIX() {
        super.aIX();
        this.lhn.setProgress(0);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i, boolean z) {
        super.setCurrentDuration(i, z);
        if (!z) {
            this.fss.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
            if (this.fsq != null) {
                this.fsq.setText(at.stringForVideoTime(i));
            }
        }
        this.lhn.setProgress(this.fss.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.VideoControllerView
    public int bCC() {
        int bCC = super.bCC();
        this.lhn.setProgress(this.fss.getProgress());
        return bCC;
    }

    public void setBottomBarShow(boolean z) {
        this.lhn.setVisibility(z ? 0 : 8);
        this.fss.setVisibility(z ? 8 : 0);
        this.fsq.setVisibility(z ? 8 : 0);
        this.fsr.setVisibility(z ? 8 : 0);
    }

    public void at(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds126);
        if (z2 && z) {
            dimens = l.getDimens(getContext(), R.dimen.tbds210);
        }
        layoutParams.height = dimens;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsq.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fsr.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds78);
        layoutParams3.rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds150 : R.dimen.tbds184);
    }
}
