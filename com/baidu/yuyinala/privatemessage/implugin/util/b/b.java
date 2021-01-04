package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes11.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    private int cOr = 0;
    private View mView;
    private final Rect pbI;
    private final int pbJ;
    private c pbK;

    public b(View view, c cVar) {
        this.mView = view;
        a.hJ(this.mView.getContext().getApplicationContext());
        this.pbI = new Rect();
        this.pbJ = (int) d.bB(60.0f);
        this.pbK = cVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.mView != null) {
            eoa();
        }
    }

    private void eoa() {
        this.mView.getRootView().getWindowVisibleDisplayFrame(this.pbI);
        int i = a.enY().heightPixels - this.pbI.bottom;
        if (this.cOr != i && i > this.pbJ) {
            this.cOr = i;
            if (this.pbK != null) {
                this.pbK.a(true, this.cOr, this.pbI.width(), this.pbI.bottom);
            }
        } else if (this.cOr != 0 && i <= this.pbJ) {
            this.cOr = 0;
            if (this.pbK != null) {
                this.pbK.a(false, this.cOr, this.pbI.width(), this.pbI.bottom);
            }
        }
    }
}
