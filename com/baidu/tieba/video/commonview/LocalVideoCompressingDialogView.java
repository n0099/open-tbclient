package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class LocalVideoCompressingDialogView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public CompressProgressView f21385e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21386f;

    public LocalVideoCompressingDialogView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.local_video_compress_dialog, this);
        this.f21385e = (CompressProgressView) findViewById(R.id.compress_progress_view);
        this.f21386f = (TextView) findViewById(R.id.compress_progress_text);
    }

    public void setPercent(int i2) {
        if (i2 < 0 || i2 > 100) {
            return;
        }
        this.f21385e.setProgress(i2);
        TextView textView = this.f21386f;
        textView.setText(i2 + "%");
    }

    public LocalVideoCompressingDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public LocalVideoCompressingDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
