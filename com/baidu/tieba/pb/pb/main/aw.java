package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public abstract class aw {
    protected BaseFragmentActivity gRv;
    protected View mRootView;

    protected abstract void a(e eVar);

    public aw(BaseFragmentActivity baseFragmentActivity, View view) {
        this.gRv = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.gRv != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
