package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eLI;
    protected View mAnchorView;
    protected Context mContext;
    protected a nEE;
    protected com.baidu.tieba.write.a nEz;
    protected int mState = 4;
    protected Rect nEJ = new Rect();
    protected Rect nEK = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Ll(int i);
    }

    public abstract void aAB();

    public abstract void dSZ();

    public abstract void dTa();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nEz = aVar;
    }

    public void a(a aVar) {
        this.nEE = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eLI = view2;
        if (this.eLI != null) {
            this.eLI.getGlobalVisibleRect(this.nEJ);
        }
    }

    public void show() {
        dSZ();
    }

    public void gh(boolean z) {
        if (z) {
            aAB();
        } else {
            dTa();
        }
    }
}
