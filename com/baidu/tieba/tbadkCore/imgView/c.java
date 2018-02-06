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
    private Rect auG = new Rect();
    public Bitmap bED;
    public Bundle hcS;
    public boolean hcT;
    public boolean hcU;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.auG.set(0, 0, this.bED.getScaledWidth(displayMetrics), this.bED.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bED, this.auG, this.rect, (Paint) null);
    }
}
