package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes7.dex */
public abstract class ar {
    protected BaseFragmentActivity gpB;
    protected View mRootView;

    protected abstract void a(d dVar);

    public ar(BaseFragmentActivity baseFragmentActivity, View view) {
        this.gpB = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.gpB != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
