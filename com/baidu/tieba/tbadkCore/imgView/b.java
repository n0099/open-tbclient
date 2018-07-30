package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class b {
    public Bitmap aXO;
    public Bundle gPY;
    public boolean gPZ;
    public boolean gQa;
    private Context mContext;
    private Rect oS = new Rect();
    public Rect rect;

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.oS.set(0, 0, this.aXO.getScaledWidth(displayMetrics), this.aXO.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aXO, this.oS, this.rect, (Paint) null);
    }
}
