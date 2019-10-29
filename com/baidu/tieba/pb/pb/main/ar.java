package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes4.dex */
public abstract class ar {
    protected BaseActivity mActivity;
    protected View mRootView;

    protected abstract void a(d dVar);

    public ar(BaseActivity baseActivity, View view) {
        this.mActivity = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.mActivity != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
