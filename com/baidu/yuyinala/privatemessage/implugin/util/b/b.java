package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private int cJF = 0;
    private View mView;
    private final Rect oXe;
    private final int oXf;
    private c oXg;

    public b(View view, c cVar) {
        this.mView = view;
        a.hH(this.mView.getContext().getApplicationContext());
        this.oXe = new Rect();
        this.oXf = (int) d.bB(60.0f);
        this.oXg = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.mView != null) {
            ekg();
        }
    }

    private void ekg() {
        this.mView.getRootView().getWindowVisibleDisplayFrame(this.oXe);
        int i = a.eke().heightPixels - this.oXe.bottom;
        if (this.cJF != i && i > this.oXf) {
            this.cJF = i;
            if (this.oXg != null) {
                this.oXg.a(true, this.cJF, this.oXe.width(), this.oXe.bottom);
            }
        } else if (this.cJF != 0 && i <= this.oXf) {
            this.cJF = 0;
            if (this.oXg != null) {
                this.oXg.a(false, this.cJF, this.oXe.width(), this.oXe.bottom);
            }
        }
    }
}
