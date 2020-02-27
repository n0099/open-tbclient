package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cYw;
    protected com.baidu.tieba.write.a kLW;
    protected a kMb;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kMg = new Rect();
    protected Rect kMh = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CO(int i);
    }

    public abstract void cUi();

    public abstract void cUj();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kLW = aVar;
    }

    public void b(a aVar) {
        this.kMb = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cYw = view2;
        if (this.cYw != null) {
            this.cYw.getGlobalVisibleRect(this.kMg);
        }
    }

    public void show() {
        cUi();
    }

    public void dt(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cUj();
        }
    }
}
