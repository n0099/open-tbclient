package com.baidu.tieba.j;

import com.baidu.adp.framework.b.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class c extends j {
    public c() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: e */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getError() == 1990055 && !a.wg(socketResponsedMessage.getCmd())) {
            a.cdR();
        }
        return socketResponsedMessage;
    }
}
