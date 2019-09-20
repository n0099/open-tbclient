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
    public Bitmap cFw;
    public Rect cyf;
    public Bundle jkQ;
    public boolean jkR;
    public boolean jkS;
    private Context mContext;
    private Rect pL = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.pL.set(0, 0, this.cFw.getScaledWidth(displayMetrics), this.cFw.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.cFw, this.pL, this.cyf, (Paint) null);
    }
}
