package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private CompressProgressView guX;
    private TextView guY;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.local_video_compress_dialog, this);
        this.guX = (CompressProgressView) findViewById(d.h.compress_progress_view);
        this.guY = (TextView) findViewById(d.h.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.guX.setProgress(i);
            this.guY.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
