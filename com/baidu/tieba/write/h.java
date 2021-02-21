package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eZA;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a odE;
    protected a odJ;
    protected int mState = 4;
    protected Rect odO = new Rect();
    protected Rect odP = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Li(int i);
    }

    public abstract void aAZ();

    public abstract void dWB();

    public abstract void dWC();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.odE = aVar;
    }

    public void a(a aVar) {
        this.odJ = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eZA = view2;
        if (this.eZA != null) {
            this.eZA.getGlobalVisibleRect(this.odO);
        }
    }

    public void show() {
        dWB();
    }

    public void gG(boolean z) {
        if (z) {
            aAZ();
        } else {
            dWC();
        }
    }
}
