package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bRk;
    protected e.a jMQ;
    protected a jMY;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jNw = new Rect();
    protected Rect jNx = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void CP(int i);
    }

    public abstract void czJ();

    public abstract void czL();

    public abstract void czM();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jMQ = aVar;
    }

    public void a(a aVar) {
        this.jMY = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bRk = view2;
        if (this.bRk != null) {
            this.bRk.getGlobalVisibleRect(this.jNw);
        }
    }

    public void show() {
        czJ();
    }

    public void bM(boolean z) {
        if (z) {
            czL();
        } else {
            czM();
        }
    }
}
