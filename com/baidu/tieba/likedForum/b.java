package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.likedForum.a;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a dCo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.dCo = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        List<ForumInfo> list;
        a.InterfaceC0070a interfaceC0070a3;
        a.InterfaceC0070a interfaceC0070a4;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.hasError()) {
                    interfaceC0070a3 = this.dCo.dCn;
                    if (interfaceC0070a3 != null) {
                        interfaceC0070a4 = this.dCo.dCn;
                        interfaceC0070a4.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                    this.dCo.dCm = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                }
                if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                    this.dCo.dCm = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                }
                interfaceC0070a = this.dCo.dCn;
                if (interfaceC0070a != null) {
                    interfaceC0070a2 = this.dCo.dCn;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    list = this.dCo.dCm;
                    interfaceC0070a2.a(true, error, errorString, list);
                }
            }
        }
    }
}
