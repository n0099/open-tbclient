package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class ao {
    protected BaseActivity boA;
    protected View mRootView;

    protected abstract void a(b bVar);

    public ao(BaseActivity baseActivity, View view) {
        this.boA = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(b bVar) {
        if (this.boA != null && this.mRootView != null) {
            a(bVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
