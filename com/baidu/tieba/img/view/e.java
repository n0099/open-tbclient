package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class e {
    public Rect Rt;
    public Bitmap bkN;
    public Bundle blB;
    public boolean blC;
    public boolean blD;
    private Context mContext;
    private Rect tN = new Rect();

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.tN.set(0, 0, this.bkN.getScaledWidth(displayMetrics), this.bkN.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bkN, this.tN, this.Rt, (Paint) null);
    }
}
