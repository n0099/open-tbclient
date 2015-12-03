package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ae implements Runnable {
    private final /* synthetic */ boolean bGQ;
    final /* synthetic */ ab dnN;
    private final /* synthetic */ BdSwitchView dnP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, boolean z, BdSwitchView bdSwitchView) {
        this.dnN = abVar;
        this.bGQ = z;
        this.dnP = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bGQ) {
            this.dnP.mF();
        } else {
            this.dnP.mE();
        }
    }
}
