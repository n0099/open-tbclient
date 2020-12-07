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
    private boolean iFp;
    private int lVn;
    private ViewTreeObserver.OnScrollChangedListener lVo;
    private a lVp;
    private boolean lVq;
    private boolean lVr;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dtQ();

        void dtR();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.lVn = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lVn = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lVn = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iFp = true;
                break;
            case 1:
            case 3:
                this.iFp = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.lVp != null) {
            this.lVp.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.lVp != null) {
            this.lVp.dtR();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.lVp != null) {
            this.lVp.dtQ();
        }
        if (this.lVo != null && this.iFp && Math.abs(i3 - i2) >= this.lVn) {
            this.lVo.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.lVq = z2;
            this.lVr = false;
            return;
        }
        this.lVq = false;
        this.lVr = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.lVo = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.lVp = aVar;
    }
}
