package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private int cJF = 0;
    private View mView;
    private final Rect oXf;
    private final int oXg;
    private c oXh;

    public b(View view, c cVar) {
        this.mView = view;
        a.hH(this.mView.getContext().getApplicationContext());
        this.oXf = new Rect();
        this.oXg = (int) d.bB(60.0f);
        this.oXh = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.mView != null) {
            ekg();
        }
    }

    private void ekg() {
        this.mView.getRootView().getWindowVisibleDisplayFrame(this.oXf);
        int i = a.eke().heightPixels - this.oXf.bottom;
        if (this.cJF != i && i > this.oXg) {
            this.cJF = i;
            if (this.oXh != null) {
                this.oXh.a(true, this.cJF, this.oXf.width(), this.oXf.bottom);
            }
        } else if (this.cJF != 0 && i <= this.oXg) {
            this.cJF = 0;
            if (this.oXh != null) {
                this.oXh.a(false, this.cJF, this.oXf.width(), this.oXf.bottom);
            }
        }
    }
}
