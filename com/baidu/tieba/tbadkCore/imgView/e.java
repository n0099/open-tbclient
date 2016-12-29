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
    private Rect Ba = new Rect();
    public Bitmap aFH;
    public Bundle fin;
    public boolean fio;
    public boolean fip;
    private Context mContext;
    public Rect rect;

    public e(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.Ba.set(0, 0, this.aFH.getScaledWidth(displayMetrics), this.aFH.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aFH, this.Ba, this.rect, (Paint) null);
    }
}
