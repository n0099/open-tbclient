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
    public Rect XX;
    public Bitmap aiR;
    public Bundle cag;
    public boolean cah;
    public boolean cai;
    private Context mContext;
    private Rect vZ = new Rect();

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.vZ.set(0, 0, this.aiR.getScaledWidth(displayMetrics), this.aiR.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aiR, this.vZ, this.XX, (Paint) null);
    }
}
