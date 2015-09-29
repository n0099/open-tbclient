package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ac implements Runnable {
    private final /* synthetic */ boolean bqV;
    final /* synthetic */ z cNw;
    private final /* synthetic */ BdSwitchView cNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cNw = zVar;
        this.bqV = z;
        this.cNy = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bqV) {
            this.cNy.mA();
        } else {
            this.cNy.mz();
        }
    }
}
