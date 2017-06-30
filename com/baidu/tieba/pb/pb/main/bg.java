package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class bg implements Runnable {
    private final /* synthetic */ Intent Dy;
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, Intent intent) {
        this.ewh = pbActivity;
        this.Dy = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        gg ggVar;
        ggVar = this.ewh.euU;
        ggVar.oW("@" + this.Dy.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
    }
}
