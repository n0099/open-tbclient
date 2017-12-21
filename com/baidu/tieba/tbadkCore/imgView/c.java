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
    private Rect GI = new Rect();
    public Bitmap aOv;
    public Bundle gDV;
    public boolean gDW;
    public boolean gDX;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GI.set(0, 0, this.aOv.getScaledWidth(displayMetrics), this.aOv.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aOv, this.GI, this.rect, (Paint) null);
    }
}
