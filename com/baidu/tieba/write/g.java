package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View dxV;
    protected com.baidu.tieba.write.a lxk;
    protected a lxp;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect lxu = new Rect();
    protected Rect lxv = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void DA(int i);
    }

    public abstract void afp();

    public abstract void dfa();

    public abstract void dfb();

    public abstract void onDestroy();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.lxk = aVar;
    }

    public void b(a aVar) {
        this.lxp = aVar;
    }

    public void c(View view, View view2) {
        this.mAnchorView = view;
        this.dxV = view2;
        if (this.dxV != null) {
            this.dxV.getGlobalVisibleRect(this.lxu);
        }
    }

    public void show() {
        dfa();
    }

    public void eq(boolean z) {
        if (z) {
            afp();
        } else {
            dfb();
        }
    }
}
