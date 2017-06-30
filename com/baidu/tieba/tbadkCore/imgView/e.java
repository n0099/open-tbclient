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
    private Rect Hz = new Rect();
    public Bitmap aLw;
    public Bundle fOe;
    public boolean fOf;
    public boolean fOg;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Hz.set(0, 0, this.aLw.getScaledWidth(displayMetrics), this.aLw.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aLw, this.Hz, this.rect, (Paint) null);
    }
}
