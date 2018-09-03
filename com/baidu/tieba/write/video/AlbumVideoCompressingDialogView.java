package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class AlbumVideoCompressingDialogView extends FrameLayout {
    private TextView hdj;
    private AlbumCompressProgressView hwN;

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
        LayoutInflater.from(context).inflate(f.h.dailog_album_video_compress, this);
        this.hwN = (AlbumCompressProgressView) findViewById(f.g.view_compress_progress);
        this.hdj = (TextView) findViewById(f.g.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.hwN.setProgress(i);
            this.hdj.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
