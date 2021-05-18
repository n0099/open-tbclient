package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import d.a.k0.d3.k0.a;
import d.a.k0.d3.k0.b;
/* loaded from: classes5.dex */
public class DragLayer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f20880e;

    /* renamed from: f  reason: collision with root package name */
    public b f20881f;

    public DragLayer(Context context) {
        super(context);
        b();
    }

    public void a() {
        b bVar = this.f20881f;
        if (bVar != null) {
            Bitmap bitmap = bVar.f53893b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f20881f.f53893b = null;
            }
            this.f20881f = null;
        }
    }

    public final void b() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b bVar = this.f20881f;
        if (bVar == null || !this.f20880e.f53888f) {
            return;
        }
        bVar.a(canvas);
    }

    public a getDragController() {
        return this.f20880e;
    }

    public b getDragObject() {
        return this.f20881f;
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
        return this.f20880e.c(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f20880e.d(motionEvent);
    }

    public void setDragController(a aVar) {
        this.f20880e = aVar;
    }

    public void setDragObject(b bVar) {
        this.f20881f = bVar;
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
