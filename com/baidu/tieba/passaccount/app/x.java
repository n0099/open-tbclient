package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements k.a {
    final /* synthetic */ SapiFastRegActivity cwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SapiFastRegActivity sapiFastRegActivity) {
        this.cwr = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        this.cwr.cwp = RegisterActivityConfig.REGIST_USER;
        this.cwr.q(accountData);
    }
}
