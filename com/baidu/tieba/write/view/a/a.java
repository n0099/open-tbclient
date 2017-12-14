package com.baidu.tieba.write.view.a;

import android.view.View;
import com.baidu.adp.base.e;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.adp.base.c {
    protected e bkK;
    protected View mRootView;

    protected abstract void initView();

    public a(e eVar) {
        super(eVar);
        this.bkK = eVar;
        initView();
    }
}
