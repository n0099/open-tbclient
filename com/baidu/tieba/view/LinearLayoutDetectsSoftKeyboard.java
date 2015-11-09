package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect aKf;
    private a dkS;

    /* loaded from: classes.dex */
    public interface a {
        void dP(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKf = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.dkS = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.aKf);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.aKf.top) - size;
        if (this.dkS != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > k.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.dkS.dP(z);
                }
                z = false;
                this.dkS.dP(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.dkS.dP(z);
                }
                z = false;
                this.dkS.dP(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
