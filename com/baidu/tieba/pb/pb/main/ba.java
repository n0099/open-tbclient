package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes22.dex */
public abstract class ba {
    protected BaseFragmentActivity hSW;
    protected View mRootView;

    protected abstract void a(e eVar);

    public ba(BaseFragmentActivity baseFragmentActivity, View view) {
        this.hSW = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.hSW != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
