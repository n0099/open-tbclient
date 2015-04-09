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
    private Rect Ha = new Rect();
    public Rect aii;
    public Bitmap arB;
    public boolean cpA;
    public boolean cpB;
    public Bundle cpz;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Ha.set(0, 0, this.arB.getScaledWidth(displayMetrics), this.arB.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.arB, this.Ha, this.aii, (Paint) null);
    }
}
