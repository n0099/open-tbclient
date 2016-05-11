package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class d {
    public Bitmap aBB;
    public Bundle euJ;
    public boolean euK;
    public boolean euL;
    private Context mContext;
    public Rect rect;
    private Rect yk = new Rect();

    public d(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.yk.set(0, 0, this.aBB.getScaledWidth(displayMetrics), this.aBB.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aBB, this.yk, this.rect, (Paint) null);
    }
}
