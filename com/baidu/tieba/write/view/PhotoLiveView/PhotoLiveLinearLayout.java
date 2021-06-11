package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class PhotoLiveLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f22024e;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public PhotoLiveLinearLayout(Context context) {
        super(context);
        this.f22024e = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a aVar = this.f22024e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setOnChangeLayoutListener(a aVar) {
        this.f22024e = aVar;
    }

    public PhotoLiveLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22024e = null;
    }
}
