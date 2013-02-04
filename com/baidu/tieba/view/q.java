package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class q extends ImageView {
    private Matrix a;
    private Paint b;
    private int c;
    private boolean d;
    private boolean e;

    public q(Context context, int i) {
        super(context);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = false;
        this.e = false;
        this.c = i;
    }

    public boolean a() {
        return this.d;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        int i = 0;
        super.onDraw(canvas);
        String str = String.valueOf((String) getTag()) + "_small";
        com.baidu.tieba.c.ab ah = TiebaApplication.a().ah();
        Bitmap c = ah != null ? ah.c(str) : null;
        if (c == null) {
            boolean z2 = this.d;
            this.d = false;
            if (this.c == 5) {
                c = com.baidu.tieba.c.e.a((int) R.drawable.video_pic);
                this.d = true;
                z = z2;
            } else {
                c = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
                z = z2;
            }
        } else {
            boolean z3 = !this.d;
            this.d = true;
            z = z3;
        }
        if (c != null) {
            int width = c.getWidth();
            int height = c.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            if (width == 0 || height == 0 || width2 == 0 || height2 == 0) {
                return;
            }
            float min = Math.min(width2 / width, height2 / height);
            if (min > 1.0f) {
                min = 1.0f;
            }
            this.a.setScale(min, min);
            if (this.e) {
                i = ((int) (width2 - (width * min))) / 2;
            } else if (z) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = (int) (width * min);
                setLayoutParams(layoutParams);
            }
            this.a.postTranslate(i, (int) (height2 - (min * height)));
            canvas.drawBitmap(c, this.a, this.b);
            this.a.reset();
        }
    }

    public void setIsThree(boolean z) {
        this.e = z;
    }

    public void setType(int i) {
        this.c = i;
    }
}
