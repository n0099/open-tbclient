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
    private int iTL;
    private ViewTreeObserver.OnScrollChangedListener iTM;
    private a iTN;
    private boolean iTO;
    private boolean iTP;
    private boolean mIsTouching;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cqV();

        void cqW();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.iTL = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iTL = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iTL = 50;
    }

    public boolean aMF() {
        return this.iTO;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.mIsTouching = true;
                break;
            case 1:
            case 3:
                this.mIsTouching = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iTN != null) {
            this.iTN.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.iTN != null) {
            this.iTN.cqW();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.iTN != null) {
            this.iTN.cqV();
        }
        if (this.iTM != null && this.mIsTouching && Math.abs(i3 - i2) >= this.iTL) {
            this.iTM.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.iTO = z2;
            this.iTP = false;
            return;
        }
        this.iTO = false;
        this.iTP = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.iTM = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.iTN = aVar;
    }
}
