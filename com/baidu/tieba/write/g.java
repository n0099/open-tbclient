package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View cYL;
    protected com.baidu.tieba.write.a kNT;
    protected a kNY;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect kOd = new Rect();
    protected Rect kOe = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CW(int i);
    }

    public abstract void cUF();

    public abstract void cUG();

    public abstract void onDestroy();

    public abstract void startHideAnimation();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.kNT = aVar;
    }

    public void b(a aVar) {
        this.kNY = aVar;
    }

    public void g(View view, View view2) {
        this.mAnchorView = view;
        this.cYL = view2;
        if (this.cYL != null) {
            this.cYL.getGlobalVisibleRect(this.kOd);
        }
    }

    public void show() {
        cUF();
    }

    public void du(boolean z) {
        if (z) {
            startHideAnimation();
        } else {
            cUG();
        }
    }
}
