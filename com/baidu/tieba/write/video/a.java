package com.baidu.tieba.write.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    private AlbumCompressProgressView hHW;
    private TextView hpE;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.dailog_album_video_compress, this);
        this.hHW = (AlbumCompressProgressView) findViewById(d.g.view_compress_progress);
        this.hpE = (TextView) findViewById(d.g.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hHW.setProgress(i);
            this.hpE.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
