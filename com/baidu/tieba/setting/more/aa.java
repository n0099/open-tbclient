package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class aa implements Runnable {
    private final /* synthetic */ boolean bnW;
    final /* synthetic */ z cGv;
    private final /* synthetic */ BdSwitchView cGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cGv = zVar;
        this.bnW = z;
        this.cGw = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bnW) {
            this.cGw.my();
        } else {
            this.cGw.mz();
        }
    }
}
