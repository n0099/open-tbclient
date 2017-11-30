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
    private Rect GH = new Rect();
    public Bitmap aOp;
    public Bundle gBh;
    public boolean gBi;
    public boolean gBj;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GH.set(0, 0, this.aOp.getScaledWidth(displayMetrics), this.aOp.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aOp, this.GH, this.rect, (Paint) null);
    }
}
