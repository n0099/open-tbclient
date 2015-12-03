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
    private Rect Hk = new Rect();
    public Bitmap aBE;
    public Bundle dBf;
    public boolean dBg;
    public boolean dBh;
    private Context mContext;
    public Rect rect;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Hk.set(0, 0, this.aBE.getScaledWidth(displayMetrics), this.aBE.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aBE, this.Hk, this.rect, (Paint) null);
    }
}
