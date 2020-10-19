package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class h {
    protected View exv;
    protected View mAnchorView;
    protected Context mContext;
    protected com.baidu.tieba.write.a nme;
    protected a nmj;
    protected int mState = 4;
    protected Rect nmo = new Rect();
    protected Rect nmp = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void KG(int i);
    }

    public abstract void awh();

    public abstract void dNr();

    public abstract void dNs();

    public abstract void onDestroy();

    public h(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.nme = aVar;
    }

    public void a(a aVar) {
        this.nmj = aVar;
    }

    public void d(View view, View view2) {
        this.mAnchorView = view;
        this.exv = view2;
        if (this.exv != null) {
            this.exv.getGlobalVisibleRect(this.nmo);
        }
    }

    public void show() {
        dNr();
    }

    public void fL(boolean z) {
        if (z) {
            awh();
        } else {
            dNs();
        }
    }
}
