package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class ay implements Runnable {
    private final /* synthetic */ Intent Dy;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity, Intent intent) {
        this.ehy = pbActivity;
        this.Dy = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        fm fmVar;
        fmVar = this.ehy.egt;
        fmVar.nP("@" + this.Dy.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
    }
}
