package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.more.AppsActivity;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ AppsActivity.a cMu;
    private final /* synthetic */ String cMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AppsActivity.a aVar, String str) {
        this.cMu = aVar;
        this.cMv = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().cashNoAccountData(this.cMv, 7);
    }
}
