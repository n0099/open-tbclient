package com.baidu.tieba.vote;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class AddVoteModel extends BdBaseModel {
    public AddVoteModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(long j, long j2, String str) {
        sendMessage(new AddVoteNetMessage(j, j2, str));
    }
}
