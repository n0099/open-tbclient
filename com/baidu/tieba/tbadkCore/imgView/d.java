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
    private Rect Bc = new Rect();
    public Bitmap aFx;
    public Bundle fxc;
    public boolean fxd;
    public boolean fxe;
    private Context mContext;
    public Rect rect;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Bc.set(0, 0, this.aFx.getScaledWidth(displayMetrics), this.aFx.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aFx, this.Bc, this.rect, (Paint) null);
    }
}
