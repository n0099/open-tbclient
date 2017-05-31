package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class bd implements Runnable {
    private final /* synthetic */ Intent Dy;
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, Intent intent) {
        this.enc = pbActivity;
        this.Dy = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        fx fxVar;
        fxVar = this.enc.elU;
        fxVar.ob("@" + this.Dy.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
    }
}
