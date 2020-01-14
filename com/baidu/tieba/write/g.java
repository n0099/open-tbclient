package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cUu;
    protected com.baidu.tieba.write.a kLq;
    protected a kLv;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kLA = new Rect();
    protected Rect kLB = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CI(int i);
    }

    public abstract void cSU();

    public abstract void cSV();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kLq = aVar;
    }

    public void b(a aVar) {
        this.kLv = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cUu = view2;
        if (this.cUu != null) {
            this.cUu.getGlobalVisibleRect(this.kLA);
        }
    }

    public void show() {
        cSU();
    }

    public void dm(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cSV();
        }
    }
}
