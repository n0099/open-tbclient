package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bIp;
    protected a jlH;
    protected e.a jlz;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jmd = new Rect();
    protected Rect jme = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Ba(int i);
    }

    public abstract void cnV();

    public abstract void cnX();

    public abstract void cnY();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jlz = aVar;
    }

    public void a(a aVar) {
        this.jlH = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bIp = view2;
        if (this.bIp != null) {
            this.bIp.getGlobalVisibleRect(this.jmd);
        }
    }

    public void show() {
        cnV();
    }

    public void bA(boolean z) {
        if (z) {
            cnX();
        } else {
            cnY();
        }
    }
}
