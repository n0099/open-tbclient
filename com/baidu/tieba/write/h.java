package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View dSV;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mlY;
    protected a mmd;
    protected int mState = 4;
    protected Rect mmi = new Rect();
    protected Rect mmj = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Fp(int i);
    }

    public abstract void ajJ();

    public abstract void dqQ();

    public abstract void dqR();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mlY = aVar;
    }

    public void b(a aVar) {
        this.mmd = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.dSV = view2;
        if (this.dSV != null) {
            this.dSV.getGlobalVisibleRect(this.mmi);
        }
    }

    public void show() {
        dqQ();
    }

    public void eO(boolean z) {
        if (z) {
            ajJ();
        } else {
            dqR();
        }
    }
}
