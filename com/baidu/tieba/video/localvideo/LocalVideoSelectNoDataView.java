package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class LocalVideoSelectNoDataView extends LinearLayout {
    public LocalVideoSelectNoDataView(Context context) {
        super(context);
        init(context);
    }

    public LocalVideoSelectNoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LocalVideoSelectNoDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.local_video_no_data_layout, this);
    }
}
