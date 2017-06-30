package com.baidu.tieba.write.transmit;

import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements a {
    final /* synthetic */ TransmitForumActivity ghI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TransmitForumActivity transmitForumActivity) {
        this.ghI = transmitForumActivity;
    }

    @Override // com.baidu.tieba.write.transmit.a
    public boolean bsR() {
        return z.s(this.ghI.bsV()) >= 3;
    }

    @Override // com.baidu.tieba.write.transmit.a
    public void bsS() {
        this.ghI.showToast(w.l.transmit_max_commit);
    }

    @Override // com.baidu.tieba.write.transmit.a
    public void bsT() {
        this.ghI.bsU();
    }
}
