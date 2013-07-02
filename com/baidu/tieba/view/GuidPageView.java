package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class GuidPageView extends ImageView {
    public GuidPageView(Context context) {
        super(context);
        b();
    }

    public GuidPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        setOnClickListener(new u(this));
    }

    public void a() {
        if (getBackground() != null) {
            Bitmap bitmap = ((BitmapDrawable) getBackground()).getBitmap();
            setBackgroundDrawable(null);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
