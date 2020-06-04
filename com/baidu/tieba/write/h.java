package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View dMf;
    protected com.baidu.tieba.write.a lRO;
    protected a lRT;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect lRZ = new Rect();
    protected Rect lSa = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void En(int i);
    }

    public abstract void aiD();

    public abstract void dmD();

    public abstract void dmE();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.lRO = aVar;
    }

    public void b(a aVar) {
        this.lRT = aVar;
    }

    public void c(View view, View view2) {
        this.mAnchorView = view;
        this.dMf = view2;
        if (this.dMf != null) {
            this.dMf.getGlobalVisibleRect(this.lRZ);
        }
    }

    public void show() {
        dmD();
    }

    public void eJ(boolean z) {
        if (z) {
            aiD();
        } else {
            dmE();
        }
    }
}
