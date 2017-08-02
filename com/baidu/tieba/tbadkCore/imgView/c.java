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
    private Rect Hz = new Rect();
    public Bitmap aME;
    public Bundle giD;
    public boolean giE;
    public boolean giF;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Hz.set(0, 0, this.aME.getScaledWidth(displayMetrics), this.aME.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aME, this.Hz, this.rect, (Paint) null);
    }
}
