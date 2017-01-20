package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ SapiFastRegActivity ecv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SapiFastRegActivity sapiFastRegActivity) {
        this.ecv = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
