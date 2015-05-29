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
    private Rect GQ = new Rect();
    public Rect aji;
    public Bitmap ate;
    public Bundle ctA;
    public boolean ctB;
    public boolean ctC;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GQ.set(0, 0, this.ate.getScaledWidth(displayMetrics), this.ate.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.ate, this.GQ, this.aji, (Paint) null);
    }
}
