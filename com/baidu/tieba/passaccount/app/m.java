package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ LoginActivity efm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LoginActivity loginActivity) {
        this.efm = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
