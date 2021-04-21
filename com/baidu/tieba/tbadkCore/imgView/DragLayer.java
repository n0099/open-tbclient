package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import d.b.j0.d3.k0.a;
import d.b.j0.d3.k0.b;
/* loaded from: classes5.dex */
public class DragLayer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21051e;

    /* renamed from: f  reason: collision with root package name */
    public b f21052f;

    public DragLayer(Context context) {
        super(context);
        b();
    }

    public void a() {
        b bVar = this.f21052f;
        if (bVar != null) {
            Bitmap bitmap = bVar.f55345b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f21052f.f55345b = null;
            }
            this.f21052f = null;
        }
    }

    public final void b() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b bVar = this.f21052f;
        if (bVar == null || !this.f21051e.f55341f) {
            return;
        }
        bVar.a(canvas);
    }

    public a getDragController() {
        return this.f21051e;
    }

    public b getDragObject() {
        return this.f21052f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f21051e.c(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f21051e.d(motionEvent);
    }

    public void setDragController(a aVar) {
        this.f21051e = aVar;
    }

    public void setDragObject(b bVar) {
        this.f21052f = bVar;
        invalidate();
    }

    public DragLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
