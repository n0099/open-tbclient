package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ah implements Runnable {
    private final /* synthetic */ boolean bYC;
    final /* synthetic */ ae edB;
    private final /* synthetic */ BdSwitchView edD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.edB = aeVar;
        this.bYC = z;
        this.edD = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bYC) {
            this.edD.mj();
        } else {
            this.edD.mi();
        }
    }
}
