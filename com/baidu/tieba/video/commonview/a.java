package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private CompressProgressView gQZ;
    private TextView gRa;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.local_video_compress_dialog, this);
        this.gQZ = (CompressProgressView) findViewById(d.g.compress_progress_view);
        this.gRa = (TextView) findViewById(d.g.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.gQZ.setProgress(i);
            this.gRa.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
