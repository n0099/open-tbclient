package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class DragContainer extends LinearLayout {
    private Scroller a;
    private Rect b;
    private View c;
    private Bitmap d;
    private final int e;

    public DragContainer(Context context) {
        super(context);
        this.b = new Rect();
        this.e = 16;
        a(context);
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Rect();
        this.e = 16;
        a(context);
    }

    private void a(Context context) {
        this.a = new Scroller(context);
    }

    public final void a(View view) {
        this.c = view;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.d = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        this.a.startScroll(this.b.top, 0, getHeight() - this.b.top, 0, 800);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c != null) {
            if (this.a.computeScrollOffset()) {
                canvas.save();
                canvas.drawBitmap(this.d, this.b.left, this.a.getCurrX(), (Paint) null);
                canvas.restore();
                postInvalidateDelayed(16L);
                return;
            }
            if (this.d != null) {
                this.d.recycle();
            }
            this.d = null;
            this.c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.forceFinished(true);
        if (this.d != null) {
            this.d.recycle();
        }
        this.d = null;
        this.c = null;
    }
}
