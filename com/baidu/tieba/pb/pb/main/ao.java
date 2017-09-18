package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class ao {
    protected BaseActivity bnc;
    protected View mRootView;

    protected abstract void a(c cVar);

    public ao(BaseActivity baseActivity, View view) {
        this.bnc = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(c cVar) {
        if (this.bnc != null && this.mRootView != null) {
            a(cVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
