package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class MeasuredWrapperRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21165e;

    /* renamed from: f  reason: collision with root package name */
    public int f21166f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21167g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i);
    }

    public MeasuredWrapperRelativeLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context, int i) {
        int size = View.MeasureSpec.getSize(i);
        int i2 = this.f21166f;
        if (i2 == 0) {
            this.f21166f = size;
        } else if (i2 == size) {
        } else {
            int i3 = i2 - size;
            if (Math.abs(i3) < context.getResources().getDimensionPixelSize(R.dimen.ds200)) {
                return;
            }
            if (i3 > 0) {
                this.f21167g = true;
            } else {
                this.f21167g = false;
            }
            b(this.f21167g, Math.abs(i3));
            this.f21166f = size;
        }
    }

    public final void b(boolean z, int i) {
        a aVar = this.f21165e;
        if (aVar != null) {
            aVar.a(z, i);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        a(getContext(), i2);
        super.onMeasure(i, i2);
    }

    public void setKeyBoardListener(a aVar) {
        this.f21165e = aVar;
    }

    public MeasuredWrapperRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeasuredWrapperRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
