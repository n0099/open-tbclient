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
    public Bitmap aXI;
    public Bundle gPa;
    public boolean gPb;
    public boolean gPc;
    private Context mContext;
    private Rect pe = new Rect();
    public Rect rect;

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.pe.set(0, 0, this.aXI.getScaledWidth(displayMetrics), this.aXI.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aXI, this.pe, this.rect, (Paint) null);
    }
}
