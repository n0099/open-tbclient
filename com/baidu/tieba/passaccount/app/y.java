package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements j.a {
    final /* synthetic */ SapiFastRegActivity dIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SapiFastRegActivity sapiFastRegActivity) {
        this.dIK = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void i(AccountData accountData) {
        this.dIK.dII = RegisterActivityConfig.REGIST_USER;
        this.dIK.q(accountData);
    }
}
