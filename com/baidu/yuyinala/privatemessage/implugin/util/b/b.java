package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private int cLT = 0;
    private View mView;
    private final Rect phS;
    private final int phT;
    private c phU;

    public b(View view, c cVar) {
        this.mView = view;
        a.hK(this.mView.getContext().getApplicationContext());
        this.phS = new Rect();
        this.phT = (int) d.bE(60.0f);
        this.phU = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.mView != null) {
            emG();
        }
    }

    private void emG() {
        this.mView.getRootView().getWindowVisibleDisplayFrame(this.phS);
        int i = a.emE().heightPixels - this.phS.bottom;
        if (this.cLT != i && i > this.phT) {
            this.cLT = i;
            if (this.phU != null) {
                this.phU.a(true, this.cLT, this.phS.width(), this.phS.bottom);
            }
        } else if (this.cLT != 0 && i <= this.phT) {
            this.cLT = 0;
            if (this.phU != null) {
                this.phU.a(false, this.cLT, this.phS.width(), this.phS.bottom);
            }
        }
    }
}
