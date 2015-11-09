package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ac implements Runnable {
    private final /* synthetic */ boolean brK;
    final /* synthetic */ z cPr;
    private final /* synthetic */ BdSwitchView cPt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cPr = zVar;
        this.brK = z;
        this.cPt = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.brK) {
            this.cPt.mB();
        } else {
            this.cPt.mA();
        }
    }
}
