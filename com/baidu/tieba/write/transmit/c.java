package com.baidu.tieba.write.transmit;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements a {
    final /* synthetic */ TransmitForumActivity fOL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TransmitForumActivity transmitForumActivity) {
        this.fOL = transmitForumActivity;
    }

    @Override // com.baidu.tieba.write.transmit.a
    public boolean bmU() {
        return x.q(this.fOL.bmY()) >= 3;
    }

    @Override // com.baidu.tieba.write.transmit.a
    public void bmV() {
        this.fOL.showToast(w.l.transmit_max_commit);
    }

    @Override // com.baidu.tieba.write.transmit.a
    public void bmW() {
        this.fOL.bmX();
    }
}
