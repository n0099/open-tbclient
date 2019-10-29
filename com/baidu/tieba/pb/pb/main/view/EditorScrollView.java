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
    private boolean fhP;
    private int hZY;
    private ViewTreeObserver.OnScrollChangedListener hZZ;
    private a iaa;
    private boolean iab;
    private boolean iac;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bWC();

        void bWD();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hZY = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZY = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZY = 50;
    }

    public boolean asq() {
        return this.iab;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.fhP = true;
                break;
            case 1:
            case 3:
                this.fhP = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iaa != null) {
            this.iaa.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.iaa != null) {
            this.iaa.bWD();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.iaa != null) {
            this.iaa.bWC();
        }
        if (this.hZZ != null && this.fhP && Math.abs(i3 - i2) >= this.hZY) {
            this.hZZ.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.iab = z2;
            this.iac = false;
            return;
        }
        this.iab = false;
        this.iac = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hZZ = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.iaa = aVar;
    }
}
