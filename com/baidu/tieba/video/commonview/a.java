package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private CompressProgressView guJ;
    private TextView guK;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.local_video_compress_dialog, this);
        this.guJ = (CompressProgressView) findViewById(d.h.compress_progress_view);
        this.guK = (TextView) findViewById(d.h.compress_progress_text);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.guJ.setProgress(i);
            this.guK.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
