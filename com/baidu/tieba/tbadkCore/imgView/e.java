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
    private Rect HY = new Rect();
    public Bitmap aJT;
    public Bundle fvY;
    public boolean fvZ;
    public boolean fwa;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HY.set(0, 0, this.aJT.getScaledWidth(displayMetrics), this.aJT.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aJT, this.HY, this.rect, (Paint) null);
    }
}
