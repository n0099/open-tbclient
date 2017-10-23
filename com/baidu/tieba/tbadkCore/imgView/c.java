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
    private Rect Hm = new Rect();
    public Bitmap aNc;
    public Bundle gix;
    public boolean giy;
    public boolean giz;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Hm.set(0, 0, this.aNc.getScaledWidth(displayMetrics), this.aNc.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aNc, this.Hm, this.rect, (Paint) null);
    }
}
