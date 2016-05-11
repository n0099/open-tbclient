package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ SapiFastRegActivity dce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SapiFastRegActivity sapiFastRegActivity) {
        this.dce = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m11getInst().setUsed();
    }
}
