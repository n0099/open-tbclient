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
    private Rect GU = new Rect();
    public Bitmap aND;
    public Bundle gki;
    public boolean gkj;
    public boolean gkk;
    private Context mContext;
    public Rect rect;

    public c(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.GU.set(0, 0, this.aND.getScaledWidth(displayMetrics), this.aND.getScaledHeight(displayMetrics));
        canvas.drawBitmap(this.aND, this.GU, this.rect, (Paint) null);
    }
}
