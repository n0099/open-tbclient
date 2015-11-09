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
    private Rect GT = new Rect();
    public Rect aKf;
    public Bitmap azy;
    public Bundle dcr;
    public boolean dcs;
    public boolean dct;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GT.set(0, 0, this.azy.getScaledWidth(displayMetrics), this.azy.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.azy, this.GT, this.aKf, (Paint) null);
    }
}
