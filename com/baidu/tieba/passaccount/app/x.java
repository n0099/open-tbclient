package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements k.a {
    final /* synthetic */ SapiFastRegActivity cdT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SapiFastRegActivity sapiFastRegActivity) {
        this.cdT = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void i(AccountData accountData) {
        this.cdT.cdR = RegisterActivityConfig.REGIST_USER;
        this.cdT.q(accountData);
    }
}
