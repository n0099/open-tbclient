package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bRe;
    protected e.a jLJ;
    protected a jLR;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jMp = new Rect();
    protected Rect jMq = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CN(int i);
    }

    public abstract void czo();

    public abstract void czq();

    public abstract void czr();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jLJ = aVar;
    }

    public void a(a aVar) {
        this.jLR = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bRe = view2;
        if (this.bRe != null) {
            this.bRe.getGlobalVisibleRect(this.jMp);
        }
    }

    public void show() {
        czo();
    }

    public void bM(boolean z) {
        if (z) {
            czq();
        } else {
            czr();
        }
    }
}
