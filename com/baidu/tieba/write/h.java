package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View fbS;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nXC;
    protected a nXH;
    protected int mState = 4;
    protected Rect nXM = new Rect();
    protected Rect nXN = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Mt(int i);
    }

    public abstract void aEv();

    public abstract void dXX();

    public abstract void dXY();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nXC = aVar;
    }

    public void a(a aVar) {
        this.nXH = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.fbS = view2;
        if (this.fbS != null) {
            this.fbS.getGlobalVisibleRect(this.nXM);
        }
    }

    public void show() {
        dXX();
    }

    public void gI(boolean z) {
        if (z) {
            aEv();
        } else {
            dXY();
        }
    }
}
