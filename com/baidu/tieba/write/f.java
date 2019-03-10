package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bIp;
    protected e.a jlS;
    protected a jma;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jmx = new Rect();
    protected Rect jmy = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Bb(int i);
    }

    public abstract void cof();

    public abstract void coh();

    public abstract void coi();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jlS = aVar;
    }

    public void a(a aVar) {
        this.jma = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bIp = view2;
        if (this.bIp != null) {
            this.bIp.getGlobalVisibleRect(this.jmx);
        }
    }

    public void show() {
        cof();
    }

    public void bA(boolean z) {
        if (z) {
            coh();
        } else {
            coi();
        }
    }
}
