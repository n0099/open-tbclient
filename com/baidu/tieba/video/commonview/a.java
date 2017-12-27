package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private CompressProgressView hyg;
    private TextView hyh;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.local_video_compress_dialog, this);
        this.hyg = (CompressProgressView) findViewById(d.g.compress_progress_view);
        this.hyh = (TextView) findViewById(d.g.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hyg.setProgress(i);
            this.hyh.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
