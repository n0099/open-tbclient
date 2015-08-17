package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ac implements Runnable {
    private final /* synthetic */ boolean bny;
    final /* synthetic */ z cxY;
    private final /* synthetic */ BdSwitchView cya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cxY = zVar;
        this.bny = z;
        this.cya = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bny) {
            this.cya.mC();
        } else {
            this.cya.mB();
        }
    }
}
