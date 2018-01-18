package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private CompressProgressView hnJ;
    private TextView hnK;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.local_video_compress_dialog, this);
        this.hnJ = (CompressProgressView) findViewById(d.g.compress_progress_view);
        this.hnK = (TextView) findViewById(d.g.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hnJ.setProgress(i);
            this.hnK.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
