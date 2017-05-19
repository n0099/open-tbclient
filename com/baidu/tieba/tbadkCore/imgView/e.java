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
    private Rect HB = new Rect();
    public Bitmap aKu;
    public Bundle fwh;
    public boolean fwi;
    public boolean fwj;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.HB.set(0, 0, this.aKu.getScaledWidth(displayMetrics), this.aKu.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aKu, this.HB, this.rect, (Paint) null);
    }
}
