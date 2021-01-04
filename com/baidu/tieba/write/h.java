package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View fbS;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nXD;
    protected a nXI;
    protected int mState = 4;
    protected Rect nXN = new Rect();
    protected Rect nXO = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Mt(int i);
    }

    public abstract void aEu();

    public abstract void dXW();

    public abstract void dXX();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nXD = aVar;
    }

    public void a(a aVar) {
        this.nXI = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.fbS = view2;
        if (this.fbS != null) {
            this.fbS.getGlobalVisibleRect(this.nXN);
        }
    }

    public void show() {
        dXW();
    }

    public void gI(boolean z) {
        if (z) {
            aEu();
        } else {
            dXX();
        }
    }
}
