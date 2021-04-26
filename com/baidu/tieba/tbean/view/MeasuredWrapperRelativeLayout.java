package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class MeasuredWrapperRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21759e;

    /* renamed from: f  reason: collision with root package name */
    public int f21760f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21761g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i2);
    }

    public MeasuredWrapperRelativeLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f21760f;
        if (i3 == 0) {
            this.f21760f = size;
        } else if (i3 == size) {
        } else {
            int i4 = i3 - size;
            if (Math.abs(i4) < context.getResources().getDimensionPixelSize(R.dimen.ds200)) {
                return;
            }
            if (i4 > 0) {
                this.f21761g = true;
            } else {
                this.f21761g = false;
            }
            b(this.f21761g, Math.abs(i4));
            this.f21760f = size;
        }
    }

    public final void b(boolean z, int i2) {
        a aVar = this.f21759e;
        if (aVar != null) {
            aVar.a(z, i2);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        a(getContext(), i3);
        super.onMeasure(i2, i3);
    }

    public void setKeyBoardListener(a aVar) {
        this.f21759e = aVar;
    }

    public MeasuredWrapperRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeasuredWrapperRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
