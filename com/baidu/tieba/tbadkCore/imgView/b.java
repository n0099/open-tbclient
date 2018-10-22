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
    public Bitmap bfJ;
    public Bundle heY;
    public boolean heZ;
    public boolean hfa;
    private Context mContext;
    public Rect rect;
    private Rect sg = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.sg.set(0, 0, this.bfJ.getScaledWidth(displayMetrics), this.bfJ.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bfJ, this.sg, this.rect, (Paint) null);
    }
}
