package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
/* loaded from: classes7.dex */
public class PbVideoMediaController extends OperableVideoMediaControllerView {
    private ProgressBar iZt;

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
        this.iZt = (ProgressBar) findViewById(R.id.pb_bottom_progress_bar);
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    protected View ep(Context context) {
        return View.inflate(context, R.layout.pb_video_media_controller, null);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void aZ(int i, int i2) {
        super.aZ(i, i2);
        this.iZt.setProgress(this.dVR.getProgress());
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void ahT() {
        super.ahT();
        this.iZt.setProgress(0);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i, boolean z) {
        super.setCurrentDuration(i, z);
        if (!z) {
            this.dVR.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
            if (this.dVP != null) {
                this.dVP.setText(aq.stringForVideoTime(i));
            }
        }
        this.iZt.setProgress(this.dVR.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.VideoControllerView
    public int aWe() {
        int aWe = super.aWe();
        this.iZt.setProgress(this.dVR.getProgress());
        return aWe;
    }

    public void setBottomBarShow(boolean z) {
        this.iZt.setVisibility(z ? 0 : 8);
        this.dVR.setVisibility(z ? 8 : 0);
        this.dVP.setVisibility(z ? 8 : 0);
        this.dVQ.setVisibility(z ? 8 : 0);
    }

    public void af(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds126);
        if (z2 && z) {
            dimens = l.getDimens(getContext(), R.dimen.tbds210);
        }
        layoutParams.height = dimens;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dVP.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dVQ.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds78);
        layoutParams3.rightMargin = l.getDimens(getContext(), (!z2 || z) ? R.dimen.tbds150 : R.dimen.tbds184);
    }
}
