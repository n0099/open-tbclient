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
    private Rect GS = new Rect();
    public Bitmap aAK;
    public Rect apD;
    public Bundle daJ;
    public boolean daK;
    public boolean daL;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GS.set(0, 0, this.aAK.getScaledWidth(displayMetrics), this.aAK.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aAK, this.GS, this.apD, (Paint) null);
    }
}
