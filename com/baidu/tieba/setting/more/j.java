package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i ceR;
    private final /* synthetic */ String ceS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.ceR = iVar;
        this.ceS = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().cashNoAccountData(this.ceS, 7);
    }
}
