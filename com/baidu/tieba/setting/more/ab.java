package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ab implements Runnable {
    private final /* synthetic */ boolean bny;
    final /* synthetic */ z cxY;
    private final /* synthetic */ BdSwitchView cxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, boolean z, BdSwitchView bdSwitchView) {
        this.cxY = zVar;
        this.bny = z;
        this.cxZ = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bny) {
            this.cxZ.mC();
        } else {
            this.cxZ.mB();
        }
    }
}
