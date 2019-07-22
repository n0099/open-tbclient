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
    public Bitmap cEy;
    public Rect cxc;
    public Bundle jhn;
    public boolean jho;
    public boolean jhp;
    private Context mContext;
    private Rect pL = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.pL.set(0, 0, this.cEy.getScaledWidth(displayMetrics), this.cEy.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.cEy, this.pL, this.cxc, (Paint) null);
    }
}
