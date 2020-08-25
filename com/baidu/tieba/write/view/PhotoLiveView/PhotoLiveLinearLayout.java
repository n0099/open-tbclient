package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class PhotoLiveLinearLayout extends LinearLayout {
    private a mSk;

    /* loaded from: classes3.dex */
    public interface a {
        void dHe();
    }

    public PhotoLiveLinearLayout(Context context) {
        super(context);
        this.mSk = null;
    }

    public PhotoLiveLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSk = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mSk != null) {
            this.mSk.dHe();
        }
    }

    public void setOnChangeLayoutListener(a aVar) {
        this.mSk = aVar;
    }
}
