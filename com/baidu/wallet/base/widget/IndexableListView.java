package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes5.dex */
public class IndexableListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f23539a;

    /* renamed from: b  reason: collision with root package name */
    public IndexScroller f23540b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector f23541c;

    public IndexableListView(Context context) {
        super(context);
        this.f23539a = false;
        this.f23540b = null;
        this.f23541c = null;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        IndexScroller indexScroller = this.f23540b;
        if (indexScroller != null) {
            indexScroller.draw(canvas);
        }
    }

    @Override // android.widget.AbsListView
    public boolean isFastScrollEnabled() {
        return this.f23539a;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f23540b.contains(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        IndexScroller indexScroller = this.f23540b;
        if (indexScroller != null) {
            indexScroller.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IndexScroller indexScroller = this.f23540b;
        if (indexScroller == null || !indexScroller.onTouchEvent(motionEvent)) {
            if (this.f23541c == null) {
                this.f23541c = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.wallet.base.widget.IndexableListView.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onFling(MotionEvent motionEvent2, MotionEvent motionEvent3, float f2, float f3) {
                        if (IndexableListView.this.f23540b != null) {
                            IndexableListView.this.f23540b.show();
                        }
                        return super.onFling(motionEvent2, motionEvent3, f2, f3);
                    }
                });
            }
            this.f23541c.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        this.f23539a = z;
        if (z) {
            if (this.f23540b == null) {
                this.f23540b = new IndexScroller(getContext(), this);
                return;
            }
            return;
        }
        IndexScroller indexScroller = this.f23540b;
        if (indexScroller != null) {
            indexScroller.hide();
            this.f23540b = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        IndexScroller indexScroller = this.f23540b;
        if (indexScroller != null) {
            indexScroller.setAdapter(listAdapter);
        }
    }

    public IndexableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23539a = false;
        this.f23540b = null;
        this.f23541c = null;
    }

    public IndexableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23539a = false;
        this.f23540b = null;
        this.f23541c = null;
    }
}
