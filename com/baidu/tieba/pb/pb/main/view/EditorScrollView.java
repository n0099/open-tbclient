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
    private boolean iUA;
    private int mhs;
    private ViewTreeObserver.OnScrollChangedListener mht;
    private a mhu;
    private boolean mhv;
    private boolean mhw;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dst();

        void dsu();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.mhs = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mhs = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mhs = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iUA = true;
                break;
            case 1:
            case 3:
                this.iUA = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mhu != null) {
            this.mhu.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.mhu != null) {
            this.mhu.dsu();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.mhu != null) {
            this.mhu.dst();
        }
        if (this.mht != null && this.iUA && Math.abs(i3 - i2) >= this.mhs) {
            this.mht.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.mhv = z2;
            this.mhw = false;
            return;
        }
        this.mhv = false;
        this.mhw = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.mht = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.mhu = aVar;
    }
}
