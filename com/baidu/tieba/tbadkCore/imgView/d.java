package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class d {
    public Bitmap aCb;
    public boolean eZA;
    public boolean eZB;
    public Bundle eZz;
    private Context mContext;
    public Rect rect;
    private Rect ym = new Rect();

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.ym.set(0, 0, this.aCb.getScaledWidth(displayMetrics), this.aCb.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aCb, this.ym, this.rect, (Paint) null);
    }
}
