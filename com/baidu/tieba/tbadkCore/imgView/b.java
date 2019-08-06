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
    public Bitmap cEF;
    public Rect cxj;
    public Bundle jiv;
    public boolean jiw;
    public boolean jix;
    private Context mContext;
    private Rect pL = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.pL.set(0, 0, this.cEF.getScaledWidth(displayMetrics), this.cEF.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.cEF, this.pL, this.cxj, (Paint) null);
    }
}
