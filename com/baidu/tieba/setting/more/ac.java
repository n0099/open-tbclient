package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ac implements Runnable {
    private final /* synthetic */ boolean brg;
    final /* synthetic */ z cNV;
    private final /* synthetic */ BdSwitchView cNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cNV = zVar;
        this.brg = z;
        this.cNX = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.brg) {
            this.cNX.mA();
        } else {
            this.cNX.mz();
        }
    }
}
