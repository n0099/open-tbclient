package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class aa implements Runnable {
    private final /* synthetic */ boolean bqV;
    final /* synthetic */ z cNw;
    private final /* synthetic */ BdSwitchView cNx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cNw = zVar;
        this.bqV = z;
        this.cNx = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bqV) {
            this.cNx.mz();
        } else {
            this.cNx.mA();
        }
    }
}
