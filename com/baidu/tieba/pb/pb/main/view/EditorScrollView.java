package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class EditorScrollView extends ScrollView {
    public View contentView;
    private boolean hrS;
    private int kAX;
    private ViewTreeObserver.OnScrollChangedListener kAY;
    private a kAZ;
    private boolean kBa;
    private boolean kBb;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cRm();

        void cRn();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.kAX = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAX = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAX = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.hrS = true;
                break;
            case 1:
            case 3:
                this.hrS = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.kAZ != null) {
            this.kAZ.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.kAZ != null) {
            this.kAZ.cRn();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.kAZ != null) {
            this.kAZ.cRm();
        }
        if (this.kAY != null && this.hrS && Math.abs(i3 - i2) >= this.kAX) {
            this.kAY.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.kBa = z2;
            this.kBb = false;
            return;
        }
        this.kBa = false;
        this.kBb = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.kAY = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.kAZ = aVar;
    }
}
