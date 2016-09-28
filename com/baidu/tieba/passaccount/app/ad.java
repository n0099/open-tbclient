package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ SapiFastRegActivity eiX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SapiFastRegActivity sapiFastRegActivity) {
        this.eiX = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
