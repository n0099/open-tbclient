package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes2.dex */
public abstract class at {
    protected BaseActivity bkU;
    protected View mRootView;

    protected abstract void a(d dVar);

    public at(BaseActivity baseActivity, View view) {
        this.bkU = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.bkU != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
