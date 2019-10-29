package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View cir;
    protected e.a jNr;
    protected a jNz;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jNX = new Rect();
    protected Rect jNY = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Bx(int i);
    }

    public abstract void cxI();

    public abstract void cxK();

    public abstract void cxL();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jNr = aVar;
    }

    public void a(a aVar) {
        this.jNz = aVar;
    }

    public void c(View view, View view2) {
        this.mAnchorView = view;
        this.cir = view2;
        if (this.cir != null) {
            this.cir.getGlobalVisibleRect(this.jNX);
        }
    }

    public void show() {
        cxI();
    }

    public void cd(boolean z) {
        if (z) {
            cxK();
        } else {
            cxL();
        }
    }
}
