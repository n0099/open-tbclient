package com.baidu.tieba.write.write;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
class v implements a.InterfaceC0086a {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0086a
    public void boz() {
        this.gaR.cT(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0086a
    public void onSuccess(List<SimpleForum> list) {
        this.gaR.cT(list);
    }
}
