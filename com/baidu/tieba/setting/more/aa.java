package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class aa implements Runnable {
    private final /* synthetic */ boolean bny;
    final /* synthetic */ z cxY;
    private final /* synthetic */ BdSwitchView cxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cxY = zVar;
        this.bny = z;
        this.cxZ = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bny) {
            this.cxZ.mB();
        } else {
            this.cxZ.mC();
        }
    }
}
