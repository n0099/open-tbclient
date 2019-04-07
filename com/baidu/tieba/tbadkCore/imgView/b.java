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
    public Bitmap cuW;
    public Bundle iHW;
    public boolean iHX;
    public boolean iHY;
    private Context mContext;
    public Rect rect;
    private Rect se = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.se.set(0, 0, this.cuW.getScaledWidth(displayMetrics), this.cuW.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.cuW, this.se, this.rect, (Paint) null);
    }
}
