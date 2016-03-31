package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ SapiFastRegActivity cZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SapiFastRegActivity sapiFastRegActivity) {
        this.cZJ = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
