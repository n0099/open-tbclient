package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class LocalVideoCompressingDialogView extends FrameLayout {
    private CompressProgressView gXP;
    private TextView gXQ;

    public LocalVideoCompressingDialogView(Context context) {
        super(context);
        init(context);
    }

    public LocalVideoCompressingDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LocalVideoCompressingDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.local_video_compress_dialog, this);
        this.gXP = (CompressProgressView) findViewById(d.g.compress_progress_view);
        this.gXQ = (TextView) findViewById(d.g.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.gXP.setProgress(i);
            this.gXQ.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
