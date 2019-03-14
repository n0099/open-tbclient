package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bIq;
    protected e.a jlK;
    protected a jlS;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jmo = new Rect();
    protected Rect jmq = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Bb(int i);
    }

    public abstract void coi();

    public abstract void cok();

    public abstract void col();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jlK = aVar;
    }

    public void a(a aVar) {
        this.jlS = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bIq = view2;
        if (this.bIq != null) {
            this.bIq.getGlobalVisibleRect(this.jmo);
        }
    }

    public void show() {
        coi();
    }

    public void bA(boolean z) {
        if (z) {
            cok();
        } else {
            col();
        }
    }
}
