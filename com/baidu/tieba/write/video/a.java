package com.baidu.tieba.write.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private AlbumCompressProgressView hQm;
    private TextView hyh;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.dailog_album_video_compress, this);
        this.hQm = (AlbumCompressProgressView) findViewById(d.g.view_compress_progress);
        this.hyh = (TextView) findViewById(d.g.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hQm.setProgress(i);
            this.hyh.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
