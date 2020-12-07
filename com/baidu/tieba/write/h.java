package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eRT;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nUg;
    protected a nUl;
    protected int mState = 4;
    protected Rect nUq = new Rect();
    protected Rect nUr = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void MG(int i);
    }

    public abstract void aDc();

    public abstract void dYs();

    public abstract void dYt();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nUg = aVar;
    }

    public void a(a aVar) {
        this.nUl = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eRT = view2;
        if (this.eRT != null) {
            this.eRT.getGlobalVisibleRect(this.nUq);
        }
    }

    public void show() {
        dYs();
    }

    public void gz(boolean z) {
        if (z) {
            aDc();
        } else {
            dYt();
        }
    }
}
