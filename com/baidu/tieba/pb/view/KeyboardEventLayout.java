package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class KeyboardEventLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f19526e;

    /* renamed from: f  reason: collision with root package name */
    public a f19527f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);
    }

    public KeyboardEventLayout(Context context) {
        super(context);
        this.f19526e = 0;
        this.f19527f = null;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        a aVar;
        super.onSizeChanged(i2, i3, i4, i5);
        int max = Math.max(Math.max(i5, i3), this.f19526e);
        this.f19526e = max;
        if (i5 == 0 || (aVar = this.f19527f) == null) {
            return;
        }
        if (i5 > i3) {
            aVar.a(0);
        } else if (i5 >= i3 || i3 < max) {
        } else {
            aVar.a(1);
        }
    }

    public void setOnKeyStateChangedListener(a aVar) {
        this.f19527f = aVar;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.f19526e = 0;
        this.f19527f = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19526e = 0;
        this.f19527f = null;
    }
}
