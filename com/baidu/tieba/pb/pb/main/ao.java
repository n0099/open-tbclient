package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public abstract class ao {
    protected BaseFragmentActivity gCM;
    protected View mRootView;

    protected abstract void a(d dVar);

    public ao(BaseFragmentActivity baseFragmentActivity, View view) {
        this.gCM = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.gCM != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
