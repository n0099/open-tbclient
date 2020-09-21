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
    private boolean hMp;
    private int kZn;
    private ViewTreeObserver.OnScrollChangedListener kZo;
    private a kZp;
    private boolean kZq;
    private boolean kZr;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dfH();

        void dfI();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.kZn = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kZn = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kZn = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.hMp = true;
                break;
            case 1:
            case 3:
                this.hMp = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.kZp != null) {
            this.kZp.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.kZp != null) {
            this.kZp.dfI();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.kZp != null) {
            this.kZp.dfH();
        }
        if (this.kZo != null && this.hMp && Math.abs(i3 - i2) >= this.kZn) {
            this.kZo.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.kZq = z2;
            this.kZr = false;
            return;
        }
        this.kZq = false;
        this.kZr = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.kZo = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.kZp = aVar;
    }
}
