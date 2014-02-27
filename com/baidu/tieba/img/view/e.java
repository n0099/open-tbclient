package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public final class e {
    public Rect a;
    public Bitmap b;
    public Bundle c;
    public boolean d;
    public boolean e;
    private Rect f = new Rect();
    private Context g;

    public e(Context context) {
        this.g = context;
    }

    public final void a(Canvas canvas) {
        DisplayMetrics displayMetrics = this.g.getResources().getDisplayMetrics();
        this.f.set(0, 0, this.b.getScaledWidth(displayMetrics), this.b.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.b, this.f, this.a, (Paint) null);
    }
}
