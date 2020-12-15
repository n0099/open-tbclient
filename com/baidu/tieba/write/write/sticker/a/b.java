package com.baidu.tieba.write.write.sticker.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes3.dex */
public class b {
    private Context mContext;
    private Rect mRect = new Rect();
    private Bitmap ogl;

    public b(Context context) {
        this.mContext = context;
    }

    public void Nf(int i) {
        this.ogl = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void a(Canvas canvas, float f, float f2) {
        if (this.ogl != null) {
            this.mRect.left = (int) (f - (this.ogl.getWidth() / 2));
            this.mRect.right = (int) ((this.ogl.getWidth() / 2) + f);
            this.mRect.top = (int) (f2 - (this.ogl.getHeight() / 2));
            this.mRect.bottom = (int) ((this.ogl.getHeight() / 2) + f2);
            canvas.drawBitmap(this.ogl, (Rect) null, this.mRect, (Paint) null);
        }
    }

    public boolean al(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.mRect.left) && motionEvent.getX(0) <= ((float) this.mRect.right) && motionEvent.getY(0) >= ((float) this.mRect.top) && motionEvent.getY(0) <= ((float) this.mRect.bottom);
    }
}
