package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.d {
    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.b.a aVar2;
        com.baidu.tbadk.b.a aVar3;
        com.baidu.tbadk.b.a aVar4;
        aVar2 = NeighborsStatic.ant;
        if (aVar2 != null) {
            aVar3 = NeighborsStatic.ant;
            if (aVar3.ao(true) != null) {
                MessageManager messageManager = MessageManager.getInstance();
                aVar4 = NeighborsStatic.ant;
                messageManager.sendMessage(new CustomMessage(2002001, aVar4.ao(true)));
                aVar.dismiss();
            }
        }
    }
}
