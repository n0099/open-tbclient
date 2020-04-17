package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public abstract class ao {
    protected BaseFragmentActivity gCG;
    protected View mRootView;

    protected abstract void a(d dVar);

    public ao(BaseFragmentActivity baseFragmentActivity, View view) {
        this.gCG = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.gCG != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
