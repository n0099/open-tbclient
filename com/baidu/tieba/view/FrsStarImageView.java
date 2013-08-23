package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsStarImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Matrix f1826a;
    private Paint b;
    private int c;
    private com.baidu.adp.widget.a.b d;
    private int e;

    public void setImageType(int i) {
        this.c = i;
    }

    public FrsStarImageView(Context context) {
        super(context);
        this.f1826a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
        this.e = 0;
    }

    public FrsStarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1826a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
        this.e = 0;
    }

    public FrsStarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1826a = new Matrix();
        this.b = new Paint();
        this.c = 0;
        this.d = null;
        this.e = 0;
    }

    private void a(int i) {
        this.e = i;
        if (i == 1) {
            this.d = new com.baidu.adp.widget.a.b(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.pic_avatar_ba_140_1, null), false, null);
        } else {
            this.d = new com.baidu.adp.widget.a.b(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.pic_avatar_ba_140, null), false, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.widget.a.b bVar;
        super.onDraw(canvas);
        com.baidu.adp.widget.a.b c = com.baidu.tbadk.a.e.a().c((String) getTag());
        int an = TiebaApplication.g().an();
        if (c == null) {
            switch (this.c) {
                case 0:
                    if (this.d == null) {
                        this.d = new com.baidu.adp.widget.a.b(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.def_star_top_pic, null), false, null);
                    }
                    bVar = this.d;
                    break;
                case 1:
                    if (this.d == null) {
                        a(an);
                    } else if (this.e != an) {
                        a(an);
                    }
                    bVar = this.d;
                    break;
                default:
                    bVar = c;
                    break;
            }
        } else {
            this.d = null;
            bVar = c;
        }
        if (bVar != null) {
            int a2 = bVar.a();
            int b = bVar.b();
            int width = getWidth();
            int height = getHeight();
            if (a2 != 0 && b != 0 && width != 0 && height != 0) {
                int a3 = this.c == 1 ? UtilHelper.a(getContext(), 3.0f) : 0;
                this.f1826a.setScale((width - (a3 * 2)) / a2, (height - (a3 * 2)) / b);
                this.f1826a.postTranslate(a3, a3);
                canvas.drawColor(0);
                bVar.a(canvas, this.f1826a, this.b);
                this.f1826a.reset();
            }
        }
    }
}
