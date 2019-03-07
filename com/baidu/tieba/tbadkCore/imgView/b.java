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
    public Bitmap cuX;
    public Bundle iIs;
    public boolean iIt;
    public boolean iIu;
    private Context mContext;
    public Rect rect;
    private Rect se = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.se.set(0, 0, this.cuX.getScaledWidth(displayMetrics), this.cuX.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.cuX, this.se, this.rect, (Paint) null);
    }
}
