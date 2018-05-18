package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a gza;
    private b gzw;

    public DragLayer(Context context) {
        super(context);
        init();
    }

    public DragLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.gza.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gza.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.gza;
    }

    public void setDragController(a aVar) {
        this.gza = aVar;
    }

    public void setDragObject(b bVar) {
        this.gzw = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.gzw;
    }

    public void bsw() {
        if (this.gzw != null) {
            if (this.gzw.aOR != null) {
                this.gzw.aOR.recycle();
                this.gzw.aOR = null;
            }
            this.gzw = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gzw != null && this.gza.gyR) {
            this.gzw.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsw();
    }
}
