package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes6.dex */
public abstract class as {
    protected BaseActivity bBi;
    protected View mRootView;

    protected abstract void a(d dVar);

    public as(BaseActivity baseActivity, View view) {
        this.bBi = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.bBi != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
