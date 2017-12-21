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
    private Bitmap gvy;
    private Context mContext;
    private Rect ru = new Rect();

    public b(Context context) {
        this.mContext = context;
    }

    public void ud(int i) {
        this.gvy = BitmapHelper.getResBitmap(this.mContext, i);
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.gvy != null) {
            this.ru.left = (int) (f - (this.gvy.getWidth() / 2));
            this.ru.right = (int) ((this.gvy.getWidth() / 2) + f);
            this.ru.top = (int) (f2 - (this.gvy.getHeight() / 2));
            this.ru.bottom = (int) ((this.gvy.getHeight() / 2) + f2);
            canvas.drawBitmap(this.gvy, (Rect) null, this.ru, (Paint) null);
        }
    }

    public boolean B(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getX(0) >= ((float) this.ru.left) && motionEvent.getX(0) <= ((float) this.ru.right) && motionEvent.getY(0) >= ((float) this.ru.top) && motionEvent.getY(0) <= ((float) this.ru.bottom);
    }
}
