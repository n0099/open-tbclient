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
    private Rect GY = new Rect();
    public Rect aia;
    public Bitmap art;
    public Bundle cpj;
    public boolean cpk;
    public boolean cpl;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GY.set(0, 0, this.art.getScaledWidth(displayMetrics), this.art.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.art, this.GY, this.aia, (Paint) null);
    }
}
