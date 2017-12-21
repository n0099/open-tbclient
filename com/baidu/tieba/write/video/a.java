package com.baidu.tieba.write.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private TextView gRf;
    private AlbumCompressProgressView hil;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.dailog_album_video_compress, this);
        this.hil = (AlbumCompressProgressView) findViewById(d.g.view_compress_progress);
        this.gRf = (TextView) findViewById(d.g.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hil.setProgress(i);
            this.gRf.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
