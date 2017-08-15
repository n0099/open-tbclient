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
    private Rect Jc = new Rect();
    public Bitmap aNT;
    public Bundle glG;
    public boolean glH;
    public boolean glI;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Jc.set(0, 0, this.aNT.getScaledWidth(displayMetrics), this.aNT.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aNT, this.Jc, this.rect, (Paint) null);
    }
}
