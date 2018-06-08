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
    public Bitmap aWN;
    public Bundle gKZ;
    public boolean gLa;
    public boolean gLb;
    private Context mContext;
    private Rect pf = new Rect();
    public Rect rect;

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.pf.set(0, 0, this.aWN.getScaledWidth(displayMetrics), this.aWN.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aWN, this.pf, this.rect, (Paint) null);
    }
}
