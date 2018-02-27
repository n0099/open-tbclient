package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class c {
    private Rect aux = new Rect();
    public Bitmap bEq;
    public Bundle hcD;
    public boolean hcE;
    public boolean hcF;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.aux.set(0, 0, this.bEq.getScaledWidth(displayMetrics), this.bEq.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bEq, this.aux, this.rect, (Paint) null);
    }
}
