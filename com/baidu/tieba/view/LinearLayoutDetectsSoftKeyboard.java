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
    Rect apc;
    private a jKF;

    /* loaded from: classes.dex */
    public interface a {
        void aL(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apc = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.jKF = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.apc);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.apc.top) - size;
        if (this.jKF != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > l.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.jKF.aL(z);
                }
                z = false;
                this.jKF.aL(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.jKF.aL(z);
                }
                z = false;
                this.jKF.aL(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
