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
    private Bitmap idy;
    private Context mContext;
    private Rect mRect = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void xL(int i) {
        this.idy = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.idy != null) {
            this.mRect.left = (int) (f - (this.idy.getWidth() / 2));
            this.mRect.right = (int) ((this.idy.getWidth() / 2) + f);
            this.mRect.top = (int) (f2 - (this.idy.getHeight() / 2));
            this.mRect.bottom = (int) ((this.idy.getHeight() / 2) + f2);
            canvas.drawBitmap(this.idy, (Rect) null, this.mRect, (Paint) null);
        }
    }

    public boolean Q(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.mRect.left) && motionEvent.getX(0) <= ((float) this.mRect.right) && motionEvent.getY(0) >= ((float) this.mRect.top) && motionEvent.getY(0) <= ((float) this.mRect.bottom);
    }
}
