package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsStarImageView extends ImageView {
    private Matrix a;
    private Paint b;
    private int c;
    private Bitmap d;
    private int e;

    public void setImageType(int i) {
        this.c = i;
    }

    public FrsStarImageView(Context context) {
        super(context);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
        this.e = 0;
    }

    public FrsStarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
        this.e = 0;
    }

    public FrsStarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
        this.e = 0;
    }

    private void a(int i) {
        this.e = i;
        if (i == 1) {
            this.d = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.pic_avatar_ba_140_1, null);
        } else {
            this.d = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.pic_avatar_ba_140, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        Bitmap c = com.baidu.tbadk.a.d.a().c((String) getTag());
        int ai = TiebaApplication.d().ai();
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
                        a(ai);
                    } else if (this.e != ai) {
                        a(ai);
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
                int a = this.c == 1 ? com.baidu.tieba.d.ag.a(getContext(), 3.0f) : 0;
                this.a.setScale((width2 - (a * 2)) / width, (height2 - (a * 2)) / height);
                this.a.postTranslate(a, a);
                canvas.drawColor(0);
                canvas.drawBitmap(bitmap, this.a, this.b);
                this.a.reset();
            }
        }
    }
}
