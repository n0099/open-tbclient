package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cYx;
    protected com.baidu.tieba.write.a kLY;
    protected a kMd;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kMi = new Rect();
    protected Rect kMj = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CO(int i);
    }

    public abstract void cUk();

    public abstract void cUl();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kLY = aVar;
    }

    public void b(a aVar) {
        this.kMd = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cYx = view2;
        if (this.cYx != null) {
            this.cYx.getGlobalVisibleRect(this.kMi);
        }
    }

    public void show() {
        cUk();
    }

    public void dt(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cUl();
        }
    }
}
