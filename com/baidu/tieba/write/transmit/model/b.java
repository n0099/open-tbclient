package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a fOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.fOX = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0083a interfaceC0083a;
        a.InterfaceC0083a interfaceC0083a2;
        List<SimpleForum> list;
        a.InterfaceC0083a interfaceC0083a3;
        a.InterfaceC0083a interfaceC0083a4;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.hasError()) {
                    interfaceC0083a3 = this.fOX.fOW;
                    if (interfaceC0083a3 != null) {
                        interfaceC0083a4 = this.fOX.fOW;
                        interfaceC0083a4.bna();
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                    this.fOX.dwN = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                    this.fOX.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                }
                if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                    this.fOX.dwN = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                    this.fOX.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                }
                interfaceC0083a = this.fOX.fOW;
                if (interfaceC0083a != null) {
                    interfaceC0083a2 = this.fOX.fOW;
                    list = this.fOX.dwN;
                    interfaceC0083a2.onSuccess(list);
                }
            }
        }
    }
}
