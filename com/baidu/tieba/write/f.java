package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bQe;
    protected e.a jEH;
    protected a jEP;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jFl = new Rect();
    protected Rect jFm = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Cg(int i);
    }

    public abstract void cwn();

    public abstract void cwp();

    public abstract void cwq();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jEH = aVar;
    }

    public void a(a aVar) {
        this.jEP = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bQe = view2;
        if (this.bQe != null) {
            this.bQe.getGlobalVisibleRect(this.jFl);
        }
    }

    public void show() {
        cwn();
    }

    public void bJ(boolean z) {
        if (z) {
            cwp();
        } else {
            cwq();
        }
    }
}
