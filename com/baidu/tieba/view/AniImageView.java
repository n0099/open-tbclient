package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AniImageView extends ImageView {
    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public AniImageView(Context context) {
        super(context);
    }

    public AniImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AniImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
