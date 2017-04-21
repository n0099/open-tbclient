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
    private Rect HB = new Rect();
    public Bitmap aKl;
    public boolean fAa;
    public Bundle fzY;
    public boolean fzZ;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HB.set(0, 0, this.aKl.getScaledWidth(displayMetrics), this.aKl.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aKl, this.HB, this.rect, (Paint) null);
    }
}
