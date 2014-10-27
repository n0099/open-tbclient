package com.baidu.tieba.im.util;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d biK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.biK = dVar;
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
            gVar = this.biK.biI;
            gVar.Ln();
        } else if (!(socketResponsedMessage instanceof ResponseRequestGroupLocMessage)) {
            gVar5 = this.biK.biI;
            gVar5.Ln();
        } else {
            ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) socketResponsedMessage;
            if (responseRequestGroupLocMessage.getError() != 0) {
                gVar4 = this.biK.biI;
                gVar4.Ln();
                return;
            }
            Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
            ArrayList arrayList = new ArrayList();
            while (iteraotrOfBusinessAreaList.hasNext()) {
                arrayList.add(iteraotrOfBusinessAreaList.next());
            }
            String position = responseRequestGroupLocMessage.getPosition();
            if ((position == null || position.equals("")) && arrayList.size() < 1) {
                gVar2 = this.biK.biI;
                gVar2.Ln();
                return;
            }
            gVar3 = this.biK.biI;
            d = this.biK.biG;
            d2 = this.biK.biF;
            gVar3.a(position, arrayList, d, d2);
        }
    }
}
