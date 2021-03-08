package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes10.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private int cNt = 0;
    private View mView;
    private final Rect pka;
    private final int pkb;
    private c pkc;

    public b(View view, c cVar) {
        this.mView = view;
        a.hJ(this.mView.getContext().getApplicationContext());
        this.pka = new Rect();
        this.pkb = (int) d.bI(60.0f);
        this.pkc = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.mView != null) {
            emQ();
        }
    }

    private void emQ() {
        this.mView.getRootView().getWindowVisibleDisplayFrame(this.pka);
        int i = a.emO().heightPixels - this.pka.bottom;
        if (this.cNt != i && i > this.pkb) {
            this.cNt = i;
            if (this.pkc != null) {
                this.pkc.a(true, this.cNt, this.pka.width(), this.pka.bottom);
            }
        } else if (this.cNt != 0 && i <= this.pkb) {
            this.cNt = 0;
            if (this.pkc != null) {
                this.pkc.a(false, this.cNt, this.pka.width(), this.pka.bottom);
            }
        }
    }
}
