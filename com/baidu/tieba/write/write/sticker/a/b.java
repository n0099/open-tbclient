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
    private Bitmap jvs;
    private Context mContext;
    private Rect mRect = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void Bz(int i) {
        this.jvs = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.jvs != null) {
            this.mRect.left = (int) (f - (this.jvs.getWidth() / 2));
            this.mRect.right = (int) ((this.jvs.getWidth() / 2) + f);
            this.mRect.top = (int) (f2 - (this.jvs.getHeight() / 2));
            this.mRect.bottom = (int) ((this.jvs.getHeight() / 2) + f2);
            canvas.drawBitmap(this.jvs, (Rect) null, this.mRect, (Paint) null);
        }
    }

    public boolean R(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.mRect.left) && motionEvent.getX(0) <= ((float) this.mRect.right) && motionEvent.getY(0) >= ((float) this.mRect.top) && motionEvent.getY(0) <= ((float) this.mRect.bottom);
    }
}
