package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ab implements Runnable {
    private final /* synthetic */ boolean bnW;
    final /* synthetic */ z cGv;
    private final /* synthetic */ BdSwitchView cGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cGv = zVar;
        this.bnW = z;
        this.cGw = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bnW) {
            this.cGw.mz();
        } else {
            this.cGw.my();
        }
    }
}
