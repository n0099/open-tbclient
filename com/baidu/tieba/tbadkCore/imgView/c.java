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
    private Rect auL = new Rect();
    public Bitmap bCz;
    public Bundle haE;
    public boolean haF;
    public boolean haG;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.auL.set(0, 0, this.bCz.getScaledWidth(displayMetrics), this.bCz.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bCz, this.auL, this.rect, (Paint) null);
    }
}
