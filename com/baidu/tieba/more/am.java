package com.baidu.tieba.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class am implements Runnable {
    private final /* synthetic */ boolean aRz;
    final /* synthetic */ aj bwt;
    private final /* synthetic */ BdSwitchView bwv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar, boolean z, BdSwitchView bdSwitchView) {
        this.bwt = ajVar;
        this.aRz = z;
        this.bwv = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRz) {
            this.bwv.iK();
        } else {
            this.bwv.iJ();
        }
    }
}
