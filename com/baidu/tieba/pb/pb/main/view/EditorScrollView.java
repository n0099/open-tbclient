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
    private int kAZ;
    private ViewTreeObserver.OnScrollChangedListener kBa;
    private a kBb;
    private boolean kBc;
    private boolean kBd;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cRm();

        void cRn();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.kAZ = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAZ = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAZ = 50;
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
        if (this.kBb != null) {
            this.kBb.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.kBb != null) {
            this.kBb.cRn();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.kBb != null) {
            this.kBb.cRm();
        }
        if (this.kBa != null && this.hrS && Math.abs(i3 - i2) >= this.kAZ) {
            this.kBa.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.kBc = z2;
            this.kBd = false;
            return;
        }
        this.kBc = false;
        this.kBd = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.kBa = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.kBb = aVar;
    }
}
