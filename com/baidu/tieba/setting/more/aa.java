package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class aa implements Runnable {
    private final /* synthetic */ boolean brg;
    final /* synthetic */ z cNV;
    private final /* synthetic */ BdSwitchView cNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cNV = zVar;
        this.brg = z;
        this.cNW = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.brg) {
            this.cNW.mz();
        } else {
            this.cNW.mA();
        }
    }
}
