package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes5.dex */
public class EditorScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public View f19362e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19363f;

    /* renamed from: g  reason: collision with root package name */
    public int f19364g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f19365h;

    /* renamed from: i  reason: collision with root package name */
    public a f19366i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c(EditorScrollView editorScrollView, int i2, int i3, int i4, int i5);
    }

    public EditorScrollView(Context context) {
        super(context);
        this.f19364g = 50;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.f19362e = getChildAt(0);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.onOverScrolled(i2, i3, z, z2);
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        a aVar;
        a aVar2;
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar3 = this.f19366i;
        if (aVar3 != null) {
            aVar3.c(this, i2, i3, i4, i5);
        }
        if (getHeight() + i3 >= this.f19362e.getHeight() && (aVar2 = this.f19366i) != null) {
            aVar2.a();
        }
        if ((i3 == 0 || getHeight() + i3 > this.f19362e.getHeight()) && (aVar = this.f19366i) != null) {
            aVar.b();
        }
        if (this.f19365h == null || !this.f19363f || Math.abs(i4 - i3) < this.f19364g) {
            return;
        }
        this.f19365h.onScrollChanged();
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
            this.f19363f = false;
            return super.onTouchEvent(motionEvent);
        }
        this.f19363f = true;
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f19365h = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.f19366i = aVar;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19364g = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19364g = 50;
    }
}
