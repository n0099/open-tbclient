package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class FrsStarImageView extends ImageView {
    private Matrix a;
    private Paint b;
    private int c;
    private Bitmap d;

    public void setImageType(int i) {
        this.c = i;
    }

    public FrsStarImageView(Context context) {
        super(context);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
    }

    public FrsStarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
    }

    public FrsStarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        String str = (String) getTag();
        com.baidu.tieba.c.ab ak = TiebaApplication.b().ak();
        Bitmap c = ak != null ? ak.c(str) : null;
        if (c == null) {
            switch (this.c) {
                case 0:
                    if (this.d == null) {
                        this.d = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.def_star_top_pic, null);
                    }
                    bitmap = this.d;
                    break;
                case 1:
                    if (this.d == null) {
                        this.d = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.def_star_photo, null);
                    }
                    bitmap = this.d;
                    break;
                default:
                    bitmap = c;
                    break;
            }
        } else {
            this.d = null;
            bitmap = c;
        }
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            if (width != 0 && height != 0 && width2 != 0 && height2 != 0) {
                int i = 0;
                if (this.c == 1) {
                    i = com.baidu.tieba.c.ah.a(getContext(), 3.0f);
                }
                this.a.setScale((width2 - (i * 2)) / width, (height2 - (i * 2)) / height);
                this.a.postTranslate(i, i);
                canvas.drawColor(-1);
                canvas.drawBitmap(bitmap, this.a, this.b);
                this.a.reset();
            }
        }
    }
}
