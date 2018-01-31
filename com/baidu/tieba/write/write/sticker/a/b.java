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
    private Bitmap hLU;
    private Rect lQ = new Rect();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public void xQ(int i) {
        this.hLU = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.hLU != null) {
            this.lQ.left = (int) (f - (this.hLU.getWidth() / 2));
            this.lQ.right = (int) ((this.hLU.getWidth() / 2) + f);
            this.lQ.top = (int) (f2 - (this.hLU.getHeight() / 2));
            this.lQ.bottom = (int) ((this.hLU.getHeight() / 2) + f2);
            canvas.drawBitmap(this.hLU, (Rect) null, this.lQ, (Paint) null);
        }
    }

    public boolean R(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.lQ.left) && motionEvent.getX(0) <= ((float) this.lQ.right) && motionEvent.getY(0) >= ((float) this.lQ.top) && motionEvent.getY(0) <= ((float) this.lQ.bottom);
    }
}
