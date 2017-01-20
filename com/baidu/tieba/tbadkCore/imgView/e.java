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
    private Rect AL = new Rect();
    public Bitmap aEw;
    public Bundle frB;
    public boolean frC;
    public boolean frD;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.AL.set(0, 0, this.aEw.getScaledWidth(displayMetrics), this.aEw.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aEw, this.AL, this.rect, (Paint) null);
    }
}
