package com.baidu.tieba.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class al implements Runnable {
    private final /* synthetic */ boolean aRz;
    final /* synthetic */ aj bwt;
    private final /* synthetic */ BdSwitchView bwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar, boolean z, BdSwitchView bdSwitchView) {
        this.bwt = ajVar;
        this.aRz = z;
        this.bwu = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRz) {
            this.bwu.iK();
        } else {
            this.bwu.iJ();
        }
    }
}
