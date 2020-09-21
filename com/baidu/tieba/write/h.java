package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View elm;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mWF;
    protected a mWK;
    protected int mState = 4;
    protected Rect mWQ = new Rect();
    protected Rect mWR = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Ka(int i);
    }

    public abstract void atw();

    public abstract void dJF();

    public abstract void dJG();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mWF = aVar;
    }

    public void a(a aVar) {
        this.mWK = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.elm = view2;
        if (this.elm != null) {
            this.elm.getGlobalVisibleRect(this.mWQ);
        }
    }

    public void show() {
        dJF();
    }

    public void fp(boolean z) {
        if (z) {
            atw();
        } else {
            dJG();
        }
    }
}
