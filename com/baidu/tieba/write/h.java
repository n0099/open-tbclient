package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eKH;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nGa;
    protected a nGf;
    protected int mState = 4;
    protected Rect nGk = new Rect();
    protected Rect nGl = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void LO(int i);
    }

    public abstract void azT();

    public abstract void dSY();

    public abstract void dSZ();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nGa = aVar;
    }

    public void a(a aVar) {
        this.nGf = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eKH = view2;
        if (this.eKH != null) {
            this.eKH.getGlobalVisibleRect(this.nGk);
        }
    }

    public void show() {
        dSY();
    }

    public void gk(boolean z) {
        if (z) {
            azT();
        } else {
            dSZ();
        }
    }
}
