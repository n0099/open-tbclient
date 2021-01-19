package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class LocalVideoCompressingDialogView extends FrameLayout {
    private TextView fgm;
    private CompressProgressView nCa;

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
        LayoutInflater.from(context).inflate(R.layout.local_video_compress_dialog, this);
        this.nCa = (CompressProgressView) findViewById(R.id.compress_progress_view);
        this.fgm = (TextView) findViewById(R.id.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.nCa.setProgress(i);
            this.fgm.setText(i + "%");
        }
    }
}
