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
    public Bitmap aKj;
    public Bundle fxI;
    public boolean fxJ;
    public boolean fxK;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Hz.set(0, 0, this.aKj.getScaledWidth(displayMetrics), this.aKj.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aKj, this.Hz, this.rect, (Paint) null);
    }
}
