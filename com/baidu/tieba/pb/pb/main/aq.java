package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public abstract class aq {
    protected BaseFragmentActivity iKH;
    protected View mRootView;

    protected abstract void a(e eVar);

    public aq(BaseFragmentActivity baseFragmentActivity, View view) {
        this.iKH = baseFragmentActivity;
        this.mRootView = view;
    }

    public void init() {
        b(null);
    }

    public void b(e eVar) {
        if (this.iKH != null && this.mRootView != null) {
            a(eVar);
        }
    }

    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
