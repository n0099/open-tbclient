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
    private a hpx;
    Rect rect;

    /* loaded from: classes.dex */
    public interface a {
        void iB(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.hpx = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.rect);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.rect.top) - size;
        if (this.hpx != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > l.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.hpx.iB(z);
                }
                z = false;
                this.hpx.iB(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.hpx.iB(z);
                }
                z = false;
                this.hpx.iB(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
