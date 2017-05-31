package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements j.a {
    final /* synthetic */ SapiFastRegActivity efv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SapiFastRegActivity sapiFastRegActivity) {
        this.efv = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void j(AccountData accountData) {
        this.efv.eft = RegisterActivityConfig.REGIST_USER;
        this.efv.r(accountData);
    }
}
