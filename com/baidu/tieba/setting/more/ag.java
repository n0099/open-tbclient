package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ag implements Runnable {
    private final /* synthetic */ boolean aZB;
    final /* synthetic */ ae cfT;
    private final /* synthetic */ BdSwitchView cfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cfT = aeVar;
        this.aZB = z;
        this.cfU = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aZB) {
            this.cfU.ms();
        } else {
            this.cfU.mr();
        }
    }
}
