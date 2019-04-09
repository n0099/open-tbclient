package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public abstract class f {
    protected View bIt;
    protected a jlH;
    protected e.a jlz;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect jmd = new Rect();
    protected Rect jme = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void AX(int i);
    }

    public abstract void cog();

    public abstract void coi();

    public abstract void coj();

    public abstract void onDestroy();

    public f(Context context, e.a aVar) {
        this.mContext = context;
        this.jlz = aVar;
    }

    public void a(a aVar) {
        this.jlH = aVar;
    }

    public void b(View view, View view2) {
        this.mAnchorView = view;
        this.bIt = view2;
        if (this.bIt != null) {
            this.bIt.getGlobalVisibleRect(this.jmd);
        }
    }

    public void show() {
        cog();
    }

    public void bA(boolean z) {
        if (z) {
            coi();
        } else {
            coj();
        }
    }
}
