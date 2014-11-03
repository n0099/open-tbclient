package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private b bon;
    private Context mContext;
    protected com.baidu.adp.base.h mLoadDataCallBack;

    public a(Context context, com.baidu.adp.base.h hVar) {
        super(context);
        this.mLoadDataCallBack = null;
        this.mContext = context;
        this.mLoadDataCallBack = hVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bon != null) {
            this.bon.cancel();
            return false;
        }
        return false;
    }

    public void Td() {
        if (this.bon == null) {
            this.bon = new b(this, null);
        }
        this.bon.setPriority(3);
        this.bon.execute(new String[0]);
    }
}
