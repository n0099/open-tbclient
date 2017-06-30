package com.baidu.tieba.write.video;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
class g implements a.InterfaceC0088a {
    final /* synthetic */ WriteVideoActivity gir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.gir = writeVideoActivity;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0088a
    public void brw() {
        this.gir.di(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0088a
    public void ci(List<SimpleForum> list) {
        this.gir.di(list);
    }
}
