package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class h {
    protected View eiT;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mMq;
    protected a mMw;
    protected int mState = 4;
    protected Rect mMB = new Rect();
    protected Rect mMC = new Rect();

    /* loaded from: classes2.dex */
    public interface a {
        void Jw(int i);
    }

    public abstract void asN();

    public abstract void dFC();

    public abstract void dFD();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mMq = aVar;
    }

    public void a(a aVar) {
        this.mMw = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eiT = view2;
        if (this.eiT != null) {
            this.eiT.getGlobalVisibleRect(this.mMB);
        }
    }

    public void show() {
        dFC();
    }

    public void fq(boolean z) {
        if (z) {
            asN();
        } else {
            dFD();
        }
    }
}
