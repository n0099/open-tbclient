package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ SapiFastRegActivity dIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SapiFastRegActivity sapiFastRegActivity) {
        this.dIK = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
