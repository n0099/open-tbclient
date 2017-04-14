package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements j.a {
    final /* synthetic */ SapiFastRegActivity eda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SapiFastRegActivity sapiFastRegActivity) {
        this.eda = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        this.eda.ecY = RegisterActivityConfig.REGIST_USER;
        this.eda.r(accountData);
    }
}
