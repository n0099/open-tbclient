package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View faZ;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a ofK;
    protected a ofP;
    protected int mState = 4;
    protected Rect ofU = new Rect();
    protected Rect ofV = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Lm(int i);
    }

    public abstract void aBc();

    public abstract void dWJ();

    public abstract void dWK();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.ofK = aVar;
    }

    public void a(a aVar) {
        this.ofP = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.faZ = view2;
        if (this.faZ != null) {
            this.faZ.getGlobalVisibleRect(this.ofU);
        }
    }

    public void show() {
        dWJ();
    }

    public void gG(boolean z) {
        if (z) {
            aBc();
        } else {
            dWK();
        }
    }
}
