package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class PbVideoMediaController extends OperableVideoMediaControllerView {
    public ProgressBar t;

    public PbVideoMediaController(Context context) {
        super(context);
        u();
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    public View l(Context context) {
        return View.inflate(context, R.layout.pb_video_media_controller, null);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void o(int i, int i2) {
        super.o(i, i2);
        this.t.setProgress(this.l.getProgress());
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void q() {
        super.q();
        this.t.setProgress(0);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public int r() {
        int r = super.r();
        this.t.setProgress(this.l.getProgress());
        return r;
    }

    public void setBottomBarShow(boolean z) {
        this.t.setVisibility(z ? 0 : 8);
        this.l.setVisibility(z ? 8 : 0);
        this.f20193h.setVisibility(z ? 8 : 0);
        this.i.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i, boolean z) {
        super.setCurrentDuration(i, z);
        if (!z) {
            this.l.setProgress((int) (((i * 1.0f) / this.p) * 10000.0f));
            TextView textView = this.f20193h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i));
            }
        }
        this.t.setProgress(this.l.getProgress());
    }

    public void t(boolean z, boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int g2 = l.g(getContext(), R.dimen.tbds126);
        if (z2 && z) {
            g2 = l.g(getContext(), R.dimen.tbds210);
        }
        layoutParams.height = g2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f20193h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams2.leftMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds78);
        layoutParams3.rightMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds150 : R.dimen.tbds184);
    }

    public final void u() {
        this.t = (ProgressBar) findViewById(R.id.pb_bottom_progress_bar);
    }

    public PbVideoMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u();
    }

    public PbVideoMediaController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u();
    }
}
