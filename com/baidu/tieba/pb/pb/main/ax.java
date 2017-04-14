package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class ax implements Runnable {
    private final /* synthetic */ Intent Dv;
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity, Intent intent) {
        this.ejU = pbActivity;
        this.Dv = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ey eyVar;
        eyVar = this.ejU.eiS;
        eyVar.nI("@" + this.Dv.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
    }
}
