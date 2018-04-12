package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes2.dex */
public abstract class at {
    protected BaseActivity bcJ;
    protected View mRootView;

    protected abstract void a(d dVar);

    public at(BaseActivity baseActivity, View view2) {
        this.bcJ = baseActivity;
        this.mRootView = view2;
    }

    public void init() {
        b(null);
    }

    public void b(d dVar) {
        if (this.bcJ != null && this.mRootView != null) {
            a(dVar);
        }
    }

    public void a(View view2, View.OnClickListener onClickListener) {
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }
}
