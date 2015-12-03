package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ad implements Runnable {
    private final /* synthetic */ boolean bGQ;
    final /* synthetic */ ab dnN;
    private final /* synthetic */ BdSwitchView dnO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, boolean z, BdSwitchView bdSwitchView) {
        this.dnN = abVar;
        this.bGQ = z;
        this.dnO = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bGQ) {
            this.dnO.mF();
        } else {
            this.dnO.mE();
        }
    }
}
