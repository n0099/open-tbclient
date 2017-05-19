package com.baidu.tieba.write.write;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
class v implements a.InterfaceC0083a {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0083a
    public void bna() {
        this.fSV.cR(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0083a
    public void onSuccess(List<SimpleForum> list) {
        this.fSV.cR(list);
    }
}
