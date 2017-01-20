package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class gl {
    protected BaseActivity aWr;
    protected View mRootView;

    protected abstract void a(e eVar);

    protected abstract void onChangeSkinType(int i);

    public gl(BaseActivity baseActivity, View view) {
        this.aWr = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.aWr != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void changeSkinType(int i) {
        onChangeSkinType(i);
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void f(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
