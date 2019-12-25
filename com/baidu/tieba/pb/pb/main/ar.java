package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public abstract class ar {
    protected BaseFragmentActivity gms;
    protected View mRootView;

    protected abstract void a(d dVar);

    public ar(BaseFragmentActivity baseFragmentActivity, View view) {
        this.gms = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.gms != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
