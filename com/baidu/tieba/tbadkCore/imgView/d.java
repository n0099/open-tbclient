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
    public Bitmap aCR;
    public Bundle fmC;
    public boolean fmD;
    public boolean fmE;
    private Context mContext;
    public Rect rect;
    private Rect yN = new Rect();

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.yN.set(0, 0, this.aCR.getScaledWidth(displayMetrics), this.aCR.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aCR, this.yN, this.rect, (Paint) null);
    }
}
