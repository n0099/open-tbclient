package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.write.transmit.model.a;
import java.util.List;
import tbclient.SimpleForum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a ghS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.ghS = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0088a interfaceC0088a;
        a.InterfaceC0088a interfaceC0088a2;
        List<SimpleForum> list;
        a.InterfaceC0088a interfaceC0088a3;
        a.InterfaceC0088a interfaceC0088a4;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.hasError()) {
                    interfaceC0088a3 = this.ghS.gdx;
                    if (interfaceC0088a3 != null) {
                        interfaceC0088a4 = this.ghS.gdx;
                        interfaceC0088a4.brw();
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                    this.ghS.dKG = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                    this.ghS.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                }
                if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                    this.ghS.dKG = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                    this.ghS.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                }
                interfaceC0088a = this.ghS.gdx;
                if (interfaceC0088a != null) {
                    interfaceC0088a2 = this.ghS.gdx;
                    list = this.ghS.dKG;
                    interfaceC0088a2.ci(list);
                }
            }
        }
    }
}
