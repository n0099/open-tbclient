package com.baidu.tieba.write.video;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
class g implements a.InterfaceC0086a {
    final /* synthetic */ WriteVideoActivity fXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.fXr = writeVideoActivity;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0086a
    public void boz() {
        this.fXr.cT(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0086a
    public void onSuccess(List<SimpleForum> list) {
        this.fXr.cT(list);
    }
}
