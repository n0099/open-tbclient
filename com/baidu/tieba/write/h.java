package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View dZn;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a mud;
    protected a mui;
    protected int mState = 4;
    protected Rect mun = new Rect();
    protected Rect muo = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void FL(int i);
    }

    public abstract void akZ();

    public abstract void duh();

    public abstract void dui();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.mud = aVar;
    }

    public void b(a aVar) {
        this.mui = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.dZn = view2;
        if (this.dZn != null) {
            this.dZn.getGlobalVisibleRect(this.mun);
        }
    }

    public void show() {
        duh();
    }

    public void eX(boolean z) {
        if (z) {
            akZ();
        } else {
            dui();
        }
    }
}
