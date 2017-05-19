package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class gs {
    protected BaseActivity bdY;
    protected View mRootView;

    protected abstract void a(e eVar);

    public gs(BaseActivity baseActivity, View view) {
        this.bdY = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.bdY != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
