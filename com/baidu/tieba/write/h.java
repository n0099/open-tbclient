package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View dZn;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mub;
    protected a mug;
    protected int mState = 4;
    protected Rect mul = new Rect();
    protected Rect mum = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void FL(int i);
    }

    public abstract void akZ();

    public abstract void dug();

    public abstract void duh();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mub = aVar;
    }

    public void b(a aVar) {
        this.mug = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.dZn = view2;
        if (this.dZn != null) {
            this.dZn.getGlobalVisibleRect(this.mul);
        }
    }

    public void show() {
        dug();
    }

    public void eX(boolean z) {
        if (z) {
            akZ();
        } else {
            duh();
        }
    }
}
