package com.baidu.tieba.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class al implements Runnable {
    private final /* synthetic */ boolean aRy;
    final /* synthetic */ aj bws;
    private final /* synthetic */ BdSwitchView bwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar, boolean z, BdSwitchView bdSwitchView) {
        this.bws = ajVar;
        this.aRy = z;
        this.bwt = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRy) {
            this.bwt.iD();
        } else {
            this.bwt.iC();
        }
    }
}
