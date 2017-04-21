package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class ax implements Runnable {
    private final /* synthetic */ Intent Dy;
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity, Intent intent) {
        this.emk = pbActivity;
        this.Dy = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ey eyVar;
        eyVar = this.emk.eli;
        eyVar.nJ("@" + this.Dy.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
    }
}
