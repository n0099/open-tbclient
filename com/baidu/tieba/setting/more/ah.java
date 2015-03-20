package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ah implements Runnable {
    private final /* synthetic */ boolean aWF;
    final /* synthetic */ ae cbc;
    private final /* synthetic */ BdSwitchView cbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cbc = aeVar;
        this.aWF = z;
        this.cbe = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aWF) {
            this.cbe.lZ();
        } else {
            this.cbe.lY();
        }
    }
}
