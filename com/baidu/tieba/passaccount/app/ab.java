package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements j.a {
    final /* synthetic */ SapiFastRegActivity eeQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SapiFastRegActivity sapiFastRegActivity) {
        this.eeQ = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        this.eeQ.eeO = RegisterActivityConfig.REGIST_USER;
        this.eeQ.r(accountData);
    }
}
