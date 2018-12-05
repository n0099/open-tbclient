package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class AlbumVideoCompressingDialogView extends FrameLayout {
    private TextView hBm;
    private AlbumCompressProgressView hVr;

    public AlbumVideoCompressingDialogView(Context context) {
        super(context);
        init(context);
    }

    public AlbumVideoCompressingDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlbumVideoCompressingDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.dailog_album_video_compress, this);
        this.hVr = (AlbumCompressProgressView) findViewById(e.g.view_compress_progress);
        this.hBm = (TextView) findViewById(e.g.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hVr.setProgress(i);
            this.hBm.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
