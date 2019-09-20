package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlbumVideoCompressingDialogView extends FrameLayout {
    private AlbumCompressProgressView jUe;
    private TextView jyG;

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
        LayoutInflater.from(context).inflate(R.layout.dailog_album_video_compress, this);
        this.jUe = (AlbumCompressProgressView) findViewById(R.id.view_compress_progress);
        this.jyG = (TextView) findViewById(R.id.txt_compress_progress);
    }

    public void setPercent(int i) {
        if (i >= 0 && i <= 100) {
            this.jUe.setProgress(i);
            this.jyG.setText(i + "%");
        }
    }

    public boolean isShowing() {
        return getParent() != null;
    }
}
