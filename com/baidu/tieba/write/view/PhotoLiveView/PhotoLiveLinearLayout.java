package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class PhotoLiveLinearLayout extends LinearLayout {
    private a gJV;

    /* loaded from: classes2.dex */
    public interface a {
        void bAm();
    }

    public PhotoLiveLinearLayout(Context context) {
        super(context);
        this.gJV = null;
    }

    public PhotoLiveLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJV = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.gJV != null) {
            this.gJV.bAm();
        }
    }

    public void setOnChangeLayoutListener(a aVar) {
        this.gJV = aVar;
    }
}
