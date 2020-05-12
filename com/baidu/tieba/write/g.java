package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class g {
    protected View dxZ;
    protected com.baidu.tieba.write.a lxo;
    protected a lxt;
    protected View mAnchorView;
    protected Context mContext;
    protected int mState = 4;
    protected Rect lxy = new Rect();
    protected Rect lxz = new Rect();

    /* loaded from: classes.dex */
    public interface a {
        void DA(int i);
    }

    public abstract void afo();

    public abstract void deY();

    public abstract void deZ();

    public abstract void onDestroy();

    public g(Context context, com.baidu.tieba.write.a aVar) {
        this.mContext = context;
        this.lxo = aVar;
    }

    public void b(a aVar) {
        this.lxt = aVar;
    }

    public void c(View view, View view2) {
        this.mAnchorView = view;
        this.dxZ = view2;
        if (this.dxZ != null) {
            this.dxZ.getGlobalVisibleRect(this.lxy);
        }
    }

    public void show() {
        deY();
    }

    public void eq(boolean z) {
        if (z) {
            afo();
        } else {
            deZ();
        }
    }
}
