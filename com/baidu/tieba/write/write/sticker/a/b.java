package com.baidu.tieba.write.write.sticker.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes13.dex */
public class b {
    private Bitmap kVv;
    private Context mContext;
    private Rect mRect = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void Ex(int i) {
        this.kVv = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void a(Canvas canvas, float f, float f2) {
        if (this.kVv != null) {
            this.mRect.left = (int) (f - (this.kVv.getWidth() / 2));
            this.mRect.right = (int) ((this.kVv.getWidth() / 2) + f);
            this.mRect.top = (int) (f2 - (this.kVv.getHeight() / 2));
            this.mRect.bottom = (int) ((this.kVv.getHeight() / 2) + f2);
            canvas.drawBitmap(this.kVv, (Rect) null, this.mRect, (Paint) null);
        }
    }

    public boolean L(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.mRect.left) && motionEvent.getX(0) <= ((float) this.mRect.right) && motionEvent.getY(0) >= ((float) this.mRect.top) && motionEvent.getY(0) <= ((float) this.mRect.bottom);
    }
}
