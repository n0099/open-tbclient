package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import d.a.j0.d3.k0.a;
import d.a.j0.d3.k0.b;
/* loaded from: classes5.dex */
public class DragLayer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21636e;

    /* renamed from: f  reason: collision with root package name */
    public b f21637f;

    public DragLayer(Context context) {
        super(context);
        b();
    }

    public void a() {
        b bVar = this.f21637f;
        if (bVar != null) {
            Bitmap bitmap = bVar.f53186b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f21637f.f53186b = null;
            }
            this.f21637f = null;
        }
    }

    public final void b() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b bVar = this.f21637f;
        if (bVar == null || !this.f21636e.f53181f) {
            return;
        }
        bVar.a(canvas);
    }

    public a getDragController() {
        return this.f21636e;
    }

    public b getDragObject() {
        return this.f21637f;
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
        return this.f21636e.c(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f21636e.d(motionEvent);
    }

    public void setDragController(a aVar) {
        this.f21636e = aVar;
    }

    public void setDragObject(b bVar) {
        this.f21637f = bVar;
        invalidate();
    }

    public DragLayer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
