package com.baidu.tieba.write.view.a;

import android.view.View;
import com.baidu.adp.base.d;
import com.baidu.adp.base.f;
/* loaded from: classes7.dex */
public abstract class a extends d {
    protected f mBdPageContext;
    protected View mRootView;

    protected abstract void initView();

    public a(f fVar) {
        super(fVar);
        this.mBdPageContext = fVar;
        initView();
    }
}
