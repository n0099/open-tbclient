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
    private Context mContext;
    private Rect mRect = new Rect();
    private Bitmap mws;

    public b(Context context) {
        this.mContext = context;
    }

    public void GZ(int i) {
        this.mws = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void a(Canvas canvas, float f, float f2) {
        if (this.mws != null) {
            this.mRect.left = (int) (f - (this.mws.getWidth() / 2));
            this.mRect.right = (int) ((this.mws.getWidth() / 2) + f);
            this.mRect.top = (int) (f2 - (this.mws.getHeight() / 2));
            this.mRect.bottom = (int) ((this.mws.getHeight() / 2) + f2);
            canvas.drawBitmap(this.mws, (Rect) null, this.mRect, (Paint) null);
        }
    }

    public boolean Q(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.mRect.left) && motionEvent.getX(0) <= ((float) this.mRect.right) && motionEvent.getY(0) >= ((float) this.mRect.top) && motionEvent.getY(0) <= ((float) this.mRect.bottom);
    }
}
