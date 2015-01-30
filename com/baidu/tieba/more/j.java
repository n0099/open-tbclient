package com.baidu.tieba.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i bvi;
    private final /* synthetic */ String bvj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.bvi = iVar;
        this.bvj = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m255getInst().cashNoAccountData(this.bvj, 7);
    }
}
