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
    public Rect bDL;
    public Bitmap bm;
    private Context mContext;
    public Bundle mZj;
    public boolean mZk;
    public boolean mZl;
    private Rect src = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.src.set(0, 0, this.bm.getScaledWidth(displayMetrics), this.bm.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.bm, this.src, this.bDL, (Paint) null);
    }
}
