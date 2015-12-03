package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.more.AppsActivity;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ AppsActivity.a dmG;
    private final /* synthetic */ String dmH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AppsActivity.a aVar, String str) {
        this.dmG = aVar;
        this.dmH = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().cashNoAccountData(this.dmH, 7);
    }
}
