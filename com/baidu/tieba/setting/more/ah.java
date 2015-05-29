package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ah implements Runnable {
    private final /* synthetic */ boolean aZB;
    final /* synthetic */ ae cfT;
    private final /* synthetic */ BdSwitchView cfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cfT = aeVar;
        this.aZB = z;
        this.cfV = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aZB) {
            this.cfV.ms();
        } else {
            this.cfV.mr();
        }
    }
}
