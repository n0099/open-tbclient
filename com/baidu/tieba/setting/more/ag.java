package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ag implements Runnable {
    private final /* synthetic */ boolean aWF;
    final /* synthetic */ ae cbc;
    private final /* synthetic */ BdSwitchView cbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cbc = aeVar;
        this.aWF = z;
        this.cbd = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aWF) {
            this.cbd.lZ();
        } else {
            this.cbd.lY();
        }
    }
}
