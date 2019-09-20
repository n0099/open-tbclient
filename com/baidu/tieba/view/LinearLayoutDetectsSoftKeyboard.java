package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect cyf;
    private a jKQ;

    /* loaded from: classes.dex */
    public interface a {
        void np(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyf = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.jKQ = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.cyf);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.cyf.top) - size;
        if (this.jKQ != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > l.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.jKQ.np(z);
                }
                z = false;
                this.jKQ.np(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.jKQ.np(z);
                }
                z = false;
                this.jKQ.np(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
