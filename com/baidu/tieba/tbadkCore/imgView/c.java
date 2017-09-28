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
    private Rect Hl = new Rect();
    public Bitmap aNp;
    public Bundle giM;
    public boolean giN;
    public boolean giO;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Hl.set(0, 0, this.aNp.getScaledWidth(displayMetrics), this.aNp.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aNp, this.Hl, this.rect, (Paint) null);
    }
}
