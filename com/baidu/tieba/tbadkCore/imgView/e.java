package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class e {
    public Rect Xu;
    public Bitmap air;
    public Bundle bYo;
    public boolean bYp;
    public boolean bYq;
    private Context mContext;
    private Rect vW = new Rect();

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.vW.set(0, 0, this.air.getScaledWidth(displayMetrics), this.air.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.air, this.vW, this.Xu, (Paint) null);
    }
}
