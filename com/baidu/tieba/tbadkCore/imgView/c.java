package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class c {
    private Rect auI = new Rect();
    public Bitmap bCr;
    public Bundle hak;
    public boolean hal;
    public boolean ham;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.auI.set(0, 0, this.bCr.getScaledWidth(displayMetrics), this.bCr.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bCr, this.auI, this.rect, (Paint) null);
    }
}
