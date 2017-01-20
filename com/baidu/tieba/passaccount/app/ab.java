package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements j.a {
    final /* synthetic */ SapiFastRegActivity ecv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SapiFastRegActivity sapiFastRegActivity) {
        this.ecv = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        this.ecv.ect = RegisterActivityConfig.REGIST_USER;
        this.ecv.r(accountData);
    }
}
