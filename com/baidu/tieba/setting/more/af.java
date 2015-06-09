package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class af implements Runnable {
    private final /* synthetic */ boolean aZC;
    final /* synthetic */ ae cfU;
    private final /* synthetic */ BdSwitchView cfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cfU = aeVar;
        this.aZC = z;
        this.cfV = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aZC) {
            this.cfV.mr();
        } else {
            this.cfV.ms();
        }
    }
}
