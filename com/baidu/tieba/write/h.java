package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View dMf;
    protected com.baidu.tieba.write.a lQD;
    protected a lQI;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect lQN = new Rect();
    protected Rect lQO = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void El(int i);
    }

    public abstract void aiD();

    public abstract void dmo();

    public abstract void dmp();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.lQD = aVar;
    }

    public void b(a aVar) {
        this.lQI = aVar;
    }

    public void c(View view, View view2) {
        this.mAnchorView = view;
        this.dMf = view2;
        if (this.dMf != null) {
            this.dMf.getGlobalVisibleRect(this.lQN);
        }
    }

    public void show() {
        dmo();
    }

    public void eJ(boolean z) {
        if (z) {
            aiD();
        } else {
            dmp();
        }
    }
}
