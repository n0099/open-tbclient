package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class b {
    private Rect Fg = new Rect();
    public Bitmap aOR;
    public Bundle gzx;
    public boolean gzy;
    public boolean gzz;
    private Context mContext;
    public Rect rect;

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Fg.set(0, 0, this.aOR.getScaledWidth(displayMetrics), this.aOR.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aOR, this.Fg, this.rect, (Paint) null);
    }
}
