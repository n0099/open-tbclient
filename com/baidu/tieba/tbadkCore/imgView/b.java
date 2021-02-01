package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b {
    public Bitmap bm;
    private Context mContext;
    public Bundle nyR;
    public boolean nyS;
    public boolean nyT;
    public Rect rect;
    private Rect src = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        this.mContext.getResources().getDisplayMetrics();
        this.src.set(0, 0, this.bm.getWidth(), this.bm.getHeight());
        canvas.drawBitmap(this.bm, this.src, this.rect, (Paint) null);
    }
}
