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
    private boolean hFo;
    private int kQL;
    private ViewTreeObserver.OnScrollChangedListener kQM;
    private a kQN;
    private boolean kQO;
    private boolean kQP;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dcd();

        void dce();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.kQL = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kQL = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kQL = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.hFo = true;
                break;
            case 1:
            case 3:
                this.hFo = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.kQN != null) {
            this.kQN.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.kQN != null) {
            this.kQN.dce();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.kQN != null) {
            this.kQN.dcd();
        }
        if (this.kQM != null && this.hFo && Math.abs(i3 - i2) >= this.kQL) {
            this.kQM.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.kQO = z2;
            this.kQP = false;
            return;
        }
        this.kQO = false;
        this.kQP = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.kQM = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.kQN = aVar;
    }
}
