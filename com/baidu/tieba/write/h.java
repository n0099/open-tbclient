package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eFT;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nyF;
    protected a nyK;
    protected int mState = 4;
    protected Rect nyP = new Rect();
    protected Rect nyQ = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void KY(int i);
    }

    public abstract void ayb();

    public abstract void dQA();

    public abstract void dQz();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nyF = aVar;
    }

    public void a(a aVar) {
        this.nyK = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eFT = view2;
        if (this.eFT != null) {
            this.eFT.getGlobalVisibleRect(this.nyP);
        }
    }

    public void show() {
        dQz();
    }

    public void fY(boolean z) {
        if (z) {
            ayb();
        } else {
            dQA();
        }
    }
}
