package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    private a fWk;
    Rect rect;

    /* loaded from: classes.dex */
    public interface a {
        void gM(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.fWk = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.rect);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.rect.top) - size;
        if (this.fWk != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > com.baidu.adp.lib.util.k.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.fWk.gM(z);
                }
                z = false;
                this.fWk.gM(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.fWk.gM(z);
                }
                z = false;
                this.fWk.gM(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
