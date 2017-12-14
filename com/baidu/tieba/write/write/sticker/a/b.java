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
    private Bitmap gvt;
    private Context mContext;
    private Rect rt = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void ud(int i) {
        this.gvt = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.gvt != null) {
            this.rt.left = (int) (f - (this.gvt.getWidth() / 2));
            this.rt.right = (int) ((this.gvt.getWidth() / 2) + f);
            this.rt.top = (int) (f2 - (this.gvt.getHeight() / 2));
            this.rt.bottom = (int) ((this.gvt.getHeight() / 2) + f2);
            canvas.drawBitmap(this.gvt, (Rect) null, this.rt, (Paint) null);
        }
    }

    public boolean B(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.rt.left) && motionEvent.getX(0) <= ((float) this.rt.right) && motionEvent.getY(0) >= ((float) this.rt.top) && motionEvent.getY(0) <= ((float) this.rt.bottom);
    }
}
