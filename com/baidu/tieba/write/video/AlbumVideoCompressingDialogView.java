package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class AlbumVideoCompressingDialogView extends FrameLayout {
    private TextView hbV;
    private AlbumCompressProgressView hvF;

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
        LayoutInflater.from(context).inflate(d.i.dailog_album_video_compress, this);
        this.hvF = (AlbumCompressProgressView) findViewById(d.g.view_compress_progress);
        this.hbV = (TextView) findViewById(d.g.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hvF.setProgress(i);
            this.hbV.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
