package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes4.dex */
public class EditorScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public View f19827e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19828f;

    /* renamed from: g  reason: collision with root package name */
    public int f19829g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f19830h;
    public a i;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);
    }

    public EditorScrollView(Context context) {
        super(context);
        this.f19829g = 50;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.f19827e = getChildAt(0);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        a aVar;
        a aVar2;
        super.onScrollChanged(i, i2, i3, i4);
        a aVar3 = this.i;
        if (aVar3 != null) {
            aVar3.c(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.f19827e.getHeight() && (aVar2 = this.i) != null) {
            aVar2.a();
        }
        if ((i2 == 0 || getHeight() + i2 > this.f19827e.getHeight()) && (aVar = this.i) != null) {
            aVar.b();
        }
        if (this.f19830h == null || !this.f19828f || Math.abs(i3 - i2) < this.f19829g) {
            return;
        }
        this.f19830h.onScrollChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            this.f19828f = false;
            return super.onTouchEvent(motionEvent);
        }
        this.f19828f = true;
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f19830h = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.i = aVar;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19829g = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19829g = 50;
    }
}
