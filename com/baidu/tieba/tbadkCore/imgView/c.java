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
    private Rect GU = new Rect();
    public Bitmap aNA;
    public Bundle glc;
    public boolean gld;
    public boolean gle;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GU.set(0, 0, this.aNA.getScaledWidth(displayMetrics), this.aNA.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aNA, this.GU, this.rect, (Paint) null);
    }
}
