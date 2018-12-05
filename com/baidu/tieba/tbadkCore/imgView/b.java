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
    public Bitmap bjV;
    public Bundle hnp;
    public boolean hnq;
    public boolean hnr;
    private Context mContext;
    public Rect rect;
    private Rect si = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.si.set(0, 0, this.bjV.getScaledWidth(displayMetrics), this.bjV.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bjV, this.si, this.rect, (Paint) null);
    }
}
