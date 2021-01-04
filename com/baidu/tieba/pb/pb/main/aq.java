package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public abstract class aq {
    protected BaseFragmentActivity iJr;
    protected View mRootView;

    protected abstract void a(e eVar);

    public aq(BaseFragmentActivity baseFragmentActivity, View view) {
        this.iJr = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.iJr != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
