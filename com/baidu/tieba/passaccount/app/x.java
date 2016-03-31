package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements j.a {
    final /* synthetic */ SapiFastRegActivity cZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SapiFastRegActivity sapiFastRegActivity) {
        this.cZJ = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void i(AccountData accountData) {
        this.cZJ.cZH = RegisterActivityConfig.REGIST_USER;
        this.cZJ.q(accountData);
    }
}
