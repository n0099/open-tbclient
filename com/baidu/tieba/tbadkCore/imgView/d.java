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
    private Rect GR = new Rect();
    public Bitmap aAn;
    public Rect aps;
    public Bundle cKd;
    public boolean cKe;
    public boolean cKf;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GR.set(0, 0, this.aAn.getScaledWidth(displayMetrics), this.aAn.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aAn, this.GR, this.aps, (Paint) null);
    }
}
