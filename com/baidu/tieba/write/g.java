package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cUk;
    protected com.baidu.tieba.write.a kHK;
    protected a kHP;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kHU = new Rect();
    protected Rect kHV = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void DT(int i);
    }

    public abstract void cRP();

    public abstract void cRQ();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kHK = aVar;
    }

    public void a(a aVar) {
        this.kHP = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cUk = view2;
        if (this.cUk != null) {
            this.cUk.getGlobalVisibleRect(this.kHU);
        }
    }

    public void show() {
        cRP();
    }

    public void dh(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cRQ();
        }
    }
}
