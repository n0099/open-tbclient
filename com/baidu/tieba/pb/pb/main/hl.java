package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class hl {
    protected BaseActivity bhX;
    protected View mRootView;

    protected abstract void a(e eVar);

    public hl(BaseActivity baseActivity, View view) {
        this.bhX = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.bhX != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
