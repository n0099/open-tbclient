package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class d {
    private Rect HT = new Rect();
    public Bitmap aFr;
    public boolean erA;
    public boolean erB;
    public Bundle erz;
    private Context mContext;
    public Rect rect;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HT.set(0, 0, this.aFr.getScaledWidth(displayMetrics), this.aFr.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aFr, this.HT, this.rect, (Paint) null);
    }
}
