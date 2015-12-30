package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ae implements Runnable {
    private final /* synthetic */ boolean bKx;
    final /* synthetic */ ac dva;
    private final /* synthetic */ BdSwitchView dvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, boolean z, BdSwitchView bdSwitchView) {
        this.dva = acVar;
        this.bKx = z;
        this.dvb = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bKx) {
            this.dvb.md();
        } else {
            this.dvb.mc();
        }
    }
}
