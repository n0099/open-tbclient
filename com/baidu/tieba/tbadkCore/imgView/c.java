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
    private Rect auJ = new Rect();
    public Bitmap bCi;
    public Bundle hkJ;
    public boolean hkK;
    public boolean hkL;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.auJ.set(0, 0, this.bCi.getScaledWidth(displayMetrics), this.bCi.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bCi, this.auJ, this.rect, (Paint) null);
    }
}
