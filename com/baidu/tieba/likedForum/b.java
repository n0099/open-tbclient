package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.likedForum.a;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a dKI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.dKI = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        List<ForumInfo> list;
        a.InterfaceC0073a interfaceC0073a3;
        a.InterfaceC0073a interfaceC0073a4;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.hasError()) {
                    interfaceC0073a3 = this.dKI.dKH;
                    if (interfaceC0073a3 != null) {
                        interfaceC0073a4 = this.dKI.dKH;
                        interfaceC0073a4.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                    this.dKI.dKG = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                }
                if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                    this.dKI.dKG = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                }
                interfaceC0073a = this.dKI.dKH;
                if (interfaceC0073a != null) {
                    interfaceC0073a2 = this.dKI.dKH;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    list = this.dKI.dKG;
                    interfaceC0073a2.a(true, error, errorString, list);
                }
            }
        }
    }
}
