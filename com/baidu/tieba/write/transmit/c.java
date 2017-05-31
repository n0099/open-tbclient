package com.baidu.tieba.write.transmit;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements a {
    final /* synthetic */ TransmitForumActivity fWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TransmitForumActivity transmitForumActivity) {
        this.fWH = transmitForumActivity;
    }

    @Override // com.baidu.tieba.write.transmit.a
    public boolean bot() {
        return x.q(this.fWH.box()) >= 3;
    }

    @Override // com.baidu.tieba.write.transmit.a
    public void bou() {
        this.fWH.showToast(w.l.transmit_max_commit);
    }

    @Override // com.baidu.tieba.write.transmit.a
    public void bov() {
        this.fWH.bow();
    }
}
