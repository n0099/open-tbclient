package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i cau;
    private final /* synthetic */ String cav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.cau = iVar;
        this.cav = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().cashNoAccountData(this.cav, 7);
    }
}
