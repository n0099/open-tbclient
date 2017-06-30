package com.baidu.tieba.write.write;

import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements a.InterfaceC0088a {
    final /* synthetic */ ck gmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(ck ckVar) {
        this.gmI = ckVar;
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0088a
    public void brw() {
        this.gmI.di(null);
    }

    @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0088a
    public void ci(List<SimpleForum> list) {
        this.gmI.di(list);
    }
}
