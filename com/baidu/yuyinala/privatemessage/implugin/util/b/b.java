package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private int cLT = 0;
    private View mView;
    private final Rect phs;
    private final int pht;
    private c phu;

    public b(View view, c cVar) {
        this.mView = view;
        a.hK(this.mView.getContext().getApplicationContext());
        this.phs = new Rect();
        this.pht = (int) d.bE(60.0f);
        this.phu = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.mView != null) {
            emy();
        }
    }

    private void emy() {
        this.mView.getRootView().getWindowVisibleDisplayFrame(this.phs);
        int i = a.emw().heightPixels - this.phs.bottom;
        if (this.cLT != i && i > this.pht) {
            this.cLT = i;
            if (this.phu != null) {
                this.phu.a(true, this.cLT, this.phs.width(), this.phs.bottom);
            }
        } else if (this.cLT != 0 && i <= this.pht) {
            this.cLT = 0;
            if (this.phu != null) {
                this.phu.a(false, this.cLT, this.phs.width(), this.phs.bottom);
            }
        }
    }
}
