package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private static int f2004a = -1;
    private boolean b;
    private int c;
    private int d;
    private boolean e;

    public void setIsSelected(boolean z) {
        this.b = z;
        invalidate();
    }

    public a(Context context) {
        super(context);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = (i3 - i) - UtilHelper.a(getContext(), 5.0f);
        this.d = (i4 - i2) - UtilHelper.a(getContext(), 5.0f);
    }

    private Bitmap getSelectIcon() {
        int i;
        if (this.b) {
            if (f2004a == 1) {
                i = R.drawable.but_posts_fit_select_s_1;
            } else {
                i = R.drawable.but_posts_fit_select_s;
            }
        } else if (f2004a == 1) {
            i = R.drawable.but_posts_fit_select_n_1;
        } else {
            i = R.drawable.but_posts_fit_select_n;
        }
        return com.baidu.tieba.util.m.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.e = true;
        } else {
            this.e = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap selectIcon = getSelectIcon();
        if (selectIcon != null && this.e) {
            canvas.drawBitmap(selectIcon, this.c - selectIcon.getWidth(), this.d - selectIcon.getHeight(), (Paint) null);
        }
    }
}
