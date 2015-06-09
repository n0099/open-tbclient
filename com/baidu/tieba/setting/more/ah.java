package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ah implements Runnable {
    private final /* synthetic */ boolean aZC;
    final /* synthetic */ ae cfU;
    private final /* synthetic */ BdSwitchView cfW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cfU = aeVar;
        this.aZC = z;
        this.cfW = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aZC) {
            this.cfW.ms();
        } else {
            this.cfW.mr();
        }
    }
}
