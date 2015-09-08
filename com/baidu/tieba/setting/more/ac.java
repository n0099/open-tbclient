package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ac implements Runnable {
    private final /* synthetic */ boolean bnW;
    final /* synthetic */ z cGv;
    private final /* synthetic */ BdSwitchView cGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cGv = zVar;
        this.bnW = z;
        this.cGx = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bnW) {
            this.cGx.mz();
        } else {
            this.cGx.my();
        }
    }
}
