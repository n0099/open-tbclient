package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class e {
    public Rect Ya;
    public Bitmap aiU;
    public Bundle cah;
    public boolean cai;
    public boolean caj;
    private Context mContext;
    private Rect wc = new Rect();

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.wc.set(0, 0, this.aiU.getScaledWidth(displayMetrics), this.aiU.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aiU, this.wc, this.Ya, (Paint) null);
    }
}
