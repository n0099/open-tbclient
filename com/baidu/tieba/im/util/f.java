package com.baidu.tieba.im.util;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d biY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.biY = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        double d;
        double d2;
        g gVar4;
        g gVar5;
        if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103010) {
            gVar = this.biY.biW;
            gVar.Lr();
        } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
            gVar5 = this.biY.biW;
            gVar5.Lr();
        } else {
            ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
            if (responseRequestGroupLocMessage.getError() != 0) {
                gVar4 = this.biY.biW;
                gVar4.Lr();
                return;
            }
            Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
            ArrayList arrayList = new ArrayList();
            while (iteraotrOfBusinessAreaList.hasNext()) {
                arrayList.add(iteraotrOfBusinessAreaList.next());
            }
            String position = responseRequestGroupLocMessage.getPosition();
            if ((position == null || position.equals("")) && arrayList.size() < 1) {
                gVar2 = this.biY.biW;
                gVar2.Lr();
                return;
            }
            gVar3 = this.biY.biW;
            d = this.biY.biU;
            d2 = this.biY.biT;
            gVar3.a(position, arrayList, d, d2);
        }
    }
}
