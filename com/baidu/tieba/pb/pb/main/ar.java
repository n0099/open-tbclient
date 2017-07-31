package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public abstract class ar {
    protected BaseActivity bmv;
    protected View mRootView;

    protected abstract void a(c cVar);

    public ar(BaseActivity baseActivity, View view) {
        this.bmv = baseActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(c cVar) {
        if (this.bmv != null && this.mRootView != null) {
            a(cVar);
        }
    }

    public void b(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
