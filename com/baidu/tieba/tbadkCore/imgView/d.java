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
    private Rect HM = new Rect();
    public Bitmap aEb;
    public Bundle dYI;
    public boolean dYJ;
    public boolean dYK;
    private Context mContext;
    public Rect rect;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HM.set(0, 0, this.aEb.getScaledWidth(displayMetrics), this.aEb.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aEb, this.HM, this.rect, (Paint) null);
    }
}
