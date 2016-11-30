package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ SapiFastRegActivity eoV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SapiFastRegActivity sapiFastRegActivity) {
        this.eoV = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
