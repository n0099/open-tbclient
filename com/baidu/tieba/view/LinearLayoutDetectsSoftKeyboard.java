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
    Rect apC;
    private a diM;

    /* loaded from: classes.dex */
    public interface a {
        void dN(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apC = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.diM = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.apC);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.apC.top) - size;
        if (this.diM != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > k.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.diM.dN(z);
                }
                z = false;
                this.diM.dN(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.diM.dN(z);
                }
                z = false;
                this.diM.dN(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
