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
    private Rect HA = new Rect();
    public Bitmap aDl;
    public Bundle dII;
    public boolean dIJ;
    public boolean dIK;
    private Context mContext;
    public Rect rect;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HA.set(0, 0, this.aDl.getScaledWidth(displayMetrics), this.aDl.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aDl, this.HA, this.rect, (Paint) null);
    }
}
