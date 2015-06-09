package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ag implements Runnable {
    private final /* synthetic */ boolean aZC;
    final /* synthetic */ ae cfU;
    private final /* synthetic */ BdSwitchView cfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cfU = aeVar;
        this.aZC = z;
        this.cfV = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aZC) {
            this.cfV.ms();
        } else {
            this.cfV.mr();
        }
    }
}
