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
    private Rect Bc = new Rect();
    public Bitmap aGn;
    public Bundle fEi;
    public boolean fEj;
    public boolean fEk;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Bc.set(0, 0, this.aGn.getScaledWidth(displayMetrics), this.aGn.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aGn, this.Bc, this.rect, (Paint) null);
    }
}
