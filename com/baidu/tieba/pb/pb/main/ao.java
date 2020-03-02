package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public abstract class ao {
    protected BaseFragmentActivity grE;
    protected View mRootView;

    protected abstract void a(d dVar);

    public ao(BaseFragmentActivity baseFragmentActivity, View view) {
        this.grE = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.grE != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
