package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bQd;
    protected e.a jEE;
    protected a jEM;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jFi = new Rect();
    protected Rect jFj = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Cg(int i);
    }

    public abstract void cwo();

    public abstract void cwq();

    public abstract void cwr();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jEE = aVar;
    }

    public void a(a aVar) {
        this.jEM = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bQd = view2;
        if (this.bQd != null) {
            this.bQd.getGlobalVisibleRect(this.jFi);
        }
    }

    public void show() {
        cwo();
    }

    public void bJ(boolean z) {
        if (z) {
            cwq();
        } else {
            cwr();
        }
    }
}
