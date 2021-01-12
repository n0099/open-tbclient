package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eXk;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nSX;
    protected a nTc;
    protected int mState = 4;
    protected Rect nTh = new Rect();
    protected Rect nTi = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void KM(int i);
    }

    public abstract void aAB();

    public abstract void dUf();

    public abstract void dUg();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nSX = aVar;
    }

    public void a(a aVar) {
        this.nTc = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eXk = view2;
        if (this.eXk != null) {
            this.eXk.getGlobalVisibleRect(this.nTh);
        }
    }

    public void show() {
        dUf();
    }

    public void gE(boolean z) {
        if (z) {
            aAB();
        } else {
            dUg();
        }
    }
}
