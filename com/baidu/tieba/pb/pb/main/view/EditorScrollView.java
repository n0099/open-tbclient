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
    private boolean inM;
    private int lBe;
    private ViewTreeObserver.OnScrollChangedListener lBf;
    private a lBg;
    private boolean lBh;
    private boolean lBi;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dmx();

        void dmy();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.lBe = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lBe = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lBe = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.inM = true;
                break;
            case 1:
            case 3:
                this.inM = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.lBg != null) {
            this.lBg.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.lBg != null) {
            this.lBg.dmy();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.lBg != null) {
            this.lBg.dmx();
        }
        if (this.lBf != null && this.inM && Math.abs(i3 - i2) >= this.lBe) {
            this.lBf.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.lBh = z2;
            this.lBi = false;
            return;
        }
        this.lBh = false;
        this.lBi = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.lBf = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.lBg = aVar;
    }
}
