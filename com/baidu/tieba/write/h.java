package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eiX;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mMI;
    protected a mMO;
    protected int mState = 4;
    protected Rect mMT = new Rect();
    protected Rect mMU = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Jw(int i);
    }

    public abstract void asN();

    public abstract void dFL();

    public abstract void dFM();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mMI = aVar;
    }

    public void a(a aVar) {
        this.mMO = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eiX = view2;
        if (this.eiX != null) {
            this.eiX.getGlobalVisibleRect(this.mMT);
        }
    }

    public void show() {
        dFL();
    }

    public void fr(boolean z) {
        if (z) {
            asN();
        } else {
            dFM();
        }
    }
}
