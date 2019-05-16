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
    public Bitmap cDg;
    public Bundle jaQ;
    public boolean jaR;
    public boolean jaS;
    private Context mContext;
    private Rect pK = new Rect();
    public Rect rect;

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.pK.set(0, 0, this.cDg.getScaledWidth(displayMetrics), this.cDg.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.cDg, this.pK, this.rect, (Paint) null);
    }
}
