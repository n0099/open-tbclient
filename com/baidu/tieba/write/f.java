package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View chz;
    protected e.a jMA;
    protected a jMI;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jNg = new Rect();
    protected Rect jNh = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void Bw(int i);
    }

    public abstract void cxG();

    public abstract void cxI();

    public abstract void cxJ();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jMA = aVar;
    }

    public void a(a aVar) {
        this.jMI = aVar;
    }

    public void c(View view, View view2) {
        this.mAnchorView = view;
        this.chz = view2;
        if (this.chz != null) {
            this.chz.getGlobalVisibleRect(this.jNg);
        }
    }

    public void show() {
        cxG();
    }

    public void cd(boolean z) {
        if (z) {
            cxI();
        } else {
            cxJ();
        }
    }
}
