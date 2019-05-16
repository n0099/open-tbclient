package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bQd;
    protected e.a jED;
    protected a jEL;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jFh = new Rect();
    protected Rect jFi = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Cg(int i);
    }

    public abstract void cwm();

    public abstract void cwo();

    public abstract void cwp();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jED = aVar;
    }

    public void a(a aVar) {
        this.jEL = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bQd = view2;
        if (this.bQd != null) {
            this.bQd.getGlobalVisibleRect(this.jFh);
        }
    }

    public void show() {
        cwm();
    }

    public void bJ(boolean z) {
        if (z) {
            cwo();
        } else {
            cwp();
        }
    }
}
