package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i ceQ;
    private final /* synthetic */ String ceR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.ceQ = iVar;
        this.ceR = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().cashNoAccountData(this.ceR, 7);
    }
}
