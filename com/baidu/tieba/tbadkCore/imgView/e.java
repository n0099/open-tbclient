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
    private Rect HA = new Rect();
    public Bitmap aKh;
    public Bundle fDZ;
    public boolean fEa;
    public boolean fEb;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HA.set(0, 0, this.aKh.getScaledWidth(displayMetrics), this.aKh.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aKh, this.HA, this.rect, (Paint) null);
    }
}
