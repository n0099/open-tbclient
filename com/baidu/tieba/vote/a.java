package com.baidu.tieba.vote;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public a(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void b(long j, long j2, String str) {
        sendMessage(new AddVoteNetMessage(j, j2, str));
    }
}
