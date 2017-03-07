package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class ax implements Runnable {
    private final /* synthetic */ Intent DU;
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity, Intent intent) {
        this.elO = pbActivity;
        this.DU = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        fa faVar;
        faVar = this.elO.ekM;
        faVar.nC("@" + this.DU.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
    }
}
