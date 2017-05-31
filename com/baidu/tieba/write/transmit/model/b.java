package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a fWT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.fWT = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0086a interfaceC0086a;
        a.InterfaceC0086a interfaceC0086a2;
        List<SimpleForum> list;
        a.InterfaceC0086a interfaceC0086a3;
        a.InterfaceC0086a interfaceC0086a4;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.hasError()) {
                    interfaceC0086a3 = this.fWT.fWS;
                    if (interfaceC0086a3 != null) {
                        interfaceC0086a4 = this.fWT.fWS;
                        interfaceC0086a4.boz();
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                    this.fWT.dCm = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                    this.fWT.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                }
                if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                    this.fWT.dCm = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                    this.fWT.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                }
                interfaceC0086a = this.fWT.fWS;
                if (interfaceC0086a != null) {
                    interfaceC0086a2 = this.fWT.fWS;
                    list = this.fWT.dCm;
                    interfaceC0086a2.onSuccess(list);
                }
            }
        }
    }
}
