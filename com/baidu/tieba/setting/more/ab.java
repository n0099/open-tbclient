package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ab implements Runnable {
    private final /* synthetic */ boolean brK;
    final /* synthetic */ z cPr;
    private final /* synthetic */ BdSwitchView cPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cPr = zVar;
        this.brK = z;
        this.cPs = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.brK) {
            this.cPs.mB();
        } else {
            this.cPs.mA();
        }
    }
}
