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
    private Rect auy = new Rect();
    public Bitmap bEt;
    public Bundle hdb;
    public boolean hdc;
    public boolean hdd;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.auy.set(0, 0, this.bEt.getScaledWidth(displayMetrics), this.bEt.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bEt, this.auy, this.rect, (Paint) null);
    }
}
