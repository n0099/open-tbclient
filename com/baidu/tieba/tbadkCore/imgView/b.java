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
    private Rect Fk = new Rect();
    public Bitmap aOQ;
    public Bundle gyw;
    public boolean gyx;
    public boolean gyy;
    private Context mContext;
    public Rect rect;

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Fk.set(0, 0, this.aOQ.getScaledWidth(displayMetrics), this.aOQ.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aOQ, this.Fk, this.rect, (Paint) null);
    }
}
