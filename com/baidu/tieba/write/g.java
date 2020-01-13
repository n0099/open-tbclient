package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cUu;
    protected com.baidu.tieba.write.a kLl;
    protected a kLq;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kLv = new Rect();
    protected Rect kLw = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CI(int i);
    }

    public abstract void cSS();

    public abstract void cST();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kLl = aVar;
    }

    public void b(a aVar) {
        this.kLq = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cUu = view2;
        if (this.cUu != null) {
            this.cUu.getGlobalVisibleRect(this.kLv);
        }
    }

    public void show() {
        cSS();
    }

    public void dm(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cST();
        }
    }
}
