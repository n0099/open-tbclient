package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View dSV;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mmb;
    protected a mmg;
    protected int mState = 4;
    protected Rect mml = new Rect();
    protected Rect mmm = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Fp(int i);
    }

    public abstract void ajJ();

    public abstract void dqU();

    public abstract void dqV();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mmb = aVar;
    }

    public void b(a aVar) {
        this.mmg = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.dSV = view2;
        if (this.dSV != null) {
            this.dSV.getGlobalVisibleRect(this.mml);
        }
    }

    public void show() {
        dqU();
    }

    public void eO(boolean z) {
        if (z) {
            ajJ();
        } else {
            dqV();
        }
    }
}
