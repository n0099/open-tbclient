package com.baidu.tieba.write.write.sticker.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes2.dex */
public class b {
    private Bitmap hNg;
    private Rect lQ = new Rect();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public void xQ(int i) {
        this.hNg = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.hNg != null) {
            this.lQ.left = (int) (f - (this.hNg.getWidth() / 2));
            this.lQ.right = (int) ((this.hNg.getWidth() / 2) + f);
            this.lQ.top = (int) (f2 - (this.hNg.getHeight() / 2));
            this.lQ.bottom = (int) ((this.hNg.getHeight() / 2) + f2);
            canvas.drawBitmap(this.hNg, (Rect) null, this.lQ, (Paint) null);
        }
    }

    public boolean V(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.lQ.left) && motionEvent.getX(0) <= ((float) this.lQ.right) && motionEvent.getY(0) >= ((float) this.lQ.top) && motionEvent.getY(0) <= ((float) this.lQ.bottom);
    }
}
