package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class PhotoLiveLinearLayout extends LinearLayout {
    private a fbg;

    /* loaded from: classes.dex */
    public interface a {
        void bcK();
    }

    public PhotoLiveLinearLayout(Context context) {
        super(context);
        this.fbg = null;
    }

    public PhotoLiveLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbg = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.fbg != null) {
            this.fbg.bcK();
        }
    }

    public void setOnChangeLayoutListener(a aVar) {
        this.fbg = aVar;
    }
}
