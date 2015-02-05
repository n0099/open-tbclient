package com.baidu.tieba.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i bvh;
    private final /* synthetic */ String bvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.bvh = iVar;
        this.bvi = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m255getInst().cashNoAccountData(this.bvi, 7);
    }
}
