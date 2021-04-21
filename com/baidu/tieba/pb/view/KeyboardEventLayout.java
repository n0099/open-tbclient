package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class KeyboardEventLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f19824e;

    /* renamed from: f  reason: collision with root package name */
    public a f19825f;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public KeyboardEventLayout(Context context) {
        super(context);
        this.f19824e = 0;
        this.f19825f = null;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        a aVar;
        super.onSizeChanged(i, i2, i3, i4);
        int max = Math.max(Math.max(i4, i2), this.f19824e);
        this.f19824e = max;
        if (i4 == 0 || (aVar = this.f19825f) == null) {
            return;
        }
        if (i4 > i2) {
            aVar.a(0);
        } else if (i4 >= i2 || i2 < max) {
        } else {
            aVar.a(1);
        }
    }

    public void setOnKeyStateChangedListener(a aVar) {
        this.f19825f = aVar;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.f19824e = 0;
        this.f19825f = null;
    }

    public KeyboardEventLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19824e = 0;
        this.f19825f = null;
    }
}
