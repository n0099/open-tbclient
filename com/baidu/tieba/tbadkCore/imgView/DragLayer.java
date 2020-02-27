package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b kiJ;
    private a kio;

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
        return this.kio.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kio.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kio;
    }

    public void setDragController(a aVar) {
        this.kio = aVar;
    }

    public void setDragObject(b bVar) {
        this.kiJ = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kiJ;
    }

    public void cLA() {
        if (this.kiJ != null) {
            if (this.kiJ.bm != null) {
                this.kiJ.bm.recycle();
                this.kiJ.bm = null;
            }
            this.kiJ = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kiJ != null && this.kio.kif) {
            this.kiJ.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cLA();
    }
}
