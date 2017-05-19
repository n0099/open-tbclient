package com.baidu.tieba.write.video;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
class g implements a.InterfaceC0083a {
    final /* synthetic */ WriteVideoActivity fPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.fPv = writeVideoActivity;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0083a
    public void bna() {
        this.fPv.cR(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0083a
    public void onSuccess(List<SimpleForum> list) {
        this.fPv.cR(list);
    }
}
