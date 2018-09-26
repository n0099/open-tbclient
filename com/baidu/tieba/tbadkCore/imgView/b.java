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
    public Bitmap bbh;
    public Bundle gXE;
    public boolean gXF;
    public boolean gXG;
    private Context mContext;
    public Rect rect;
    private Rect rt = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.rt.set(0, 0, this.bbh.getScaledWidth(displayMetrics), this.bbh.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bbh, this.rt, this.rect, (Paint) null);
    }
}
