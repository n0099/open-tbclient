package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ LoginActivity egU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.egU = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
