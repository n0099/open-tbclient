package com.baidu.tieba.write.view.a;

import android.view.View;
import com.baidu.adp.base.e;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.adp.base.c {
    protected e mBdPageContext;
    protected View mRootView;

    protected abstract void initView();

    public a(e eVar) {
        super(eVar);
        this.mBdPageContext = eVar;
        initView();
    }
}
