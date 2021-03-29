package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class AlbumVideoCompressingDialogView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public AlbumCompressProgressView f22355e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22356f;

    public AlbumVideoCompressingDialogView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.dailog_album_video_compress, this);
        this.f22355e = (AlbumCompressProgressView) findViewById(R.id.view_compress_progress);
        this.f22356f = (TextView) findViewById(R.id.txt_compress_progress);
    }

    public boolean b() {
        return getParent() != null;
    }

    public void setPercent(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.f22355e.setProgress(i);
        TextView textView = this.f22356f;
        textView.setText(i + "%");
    }

    public AlbumVideoCompressingDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AlbumVideoCompressingDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
