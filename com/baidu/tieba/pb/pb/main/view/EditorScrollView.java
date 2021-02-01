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
    private boolean iSD;
    private int mfb;
    private ViewTreeObserver.OnScrollChangedListener mfc;
    private a mfd;
    private boolean mfe;
    private boolean mff;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dsd();

        void dse();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.mfb = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mfb = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mfb = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iSD = true;
                break;
            case 1:
            case 3:
                this.iSD = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mfd != null) {
            this.mfd.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.mfd != null) {
            this.mfd.dse();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.mfd != null) {
            this.mfd.dsd();
        }
        if (this.mfc != null && this.iSD && Math.abs(i3 - i2) >= this.mfb) {
            this.mfc.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.mfe = z2;
            this.mff = false;
            return;
        }
        this.mfe = false;
        this.mff = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.mfc = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.mfd = aVar;
    }
}
