package com.baidu.tieba.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class am implements Runnable {
    private final /* synthetic */ boolean aRy;
    final /* synthetic */ aj bws;
    private final /* synthetic */ BdSwitchView bwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar, boolean z, BdSwitchView bdSwitchView) {
        this.bws = ajVar;
        this.aRy = z;
        this.bwu = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRy) {
            this.bwu.iD();
        } else {
            this.bwu.iC();
        }
    }
}
