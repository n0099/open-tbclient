package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bRL;
    protected e.a jPl;
    protected a jPt;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jPR = new Rect();
    protected Rect jPS = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CT(int i);
    }

    public abstract void cAA();

    public abstract void cAx();

    public abstract void cAz();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jPl = aVar;
    }

    public void a(a aVar) {
        this.jPt = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bRL = view2;
        if (this.bRL != null) {
            this.bRL.getGlobalVisibleRect(this.jPR);
        }
    }

    public void show() {
        cAx();
    }

    public void bM(boolean z) {
        if (z) {
            cAz();
        } else {
            cAA();
        }
    }
}
