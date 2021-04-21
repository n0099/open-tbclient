package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class PhotoLiveLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f22065e;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public PhotoLiveLinearLayout(Context context) {
        super(context);
        this.f22065e = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a aVar = this.f22065e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setOnChangeLayoutListener(a aVar) {
        this.f22065e = aVar;
    }

    public PhotoLiveLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22065e = null;
    }
}
