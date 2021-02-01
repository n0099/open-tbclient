package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View eZA;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a ode;
    protected a odj;
    protected int mState = 4;
    protected Rect odo = new Rect();
    protected Rect odp = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Lh(int i);
    }

    public abstract void aAZ();

    public abstract void dWt();

    public abstract void dWu();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.ode = aVar;
    }

    public void a(a aVar) {
        this.odj = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.eZA = view2;
        if (this.eZA != null) {
            this.eZA.getGlobalVisibleRect(this.odo);
        }
    }

    public void show() {
        dWt();
    }

    public void gG(boolean z) {
        if (z) {
            aAZ();
        } else {
            dWu();
        }
    }
}
