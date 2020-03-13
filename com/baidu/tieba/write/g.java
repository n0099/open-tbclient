package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cYy;
    protected com.baidu.tieba.write.a kMk;
    protected a kMp;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kMu = new Rect();
    protected Rect kMv = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CO(int i);
    }

    public abstract void cUl();

    public abstract void cUm();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kMk = aVar;
    }

    public void b(a aVar) {
        this.kMp = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cYy = view2;
        if (this.cYy != null) {
            this.cYy.getGlobalVisibleRect(this.kMu);
        }
    }

    public void show() {
        cUl();
    }

    public void dt(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cUm();
        }
    }
}
