package com.baidu.tieba.util;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f2577a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.f2577a = aaVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        double d;
        double d2;
        ad adVar4;
        ad adVar5;
        if (message == null || message.getCmd() != 103010) {
            adVar = this.f2577a.d;
            adVar.a();
        } else if (!(message instanceof ResponseRequestGroupLocMessage)) {
            adVar5 = this.f2577a.d;
            adVar5.a();
        } else {
            ResponseRequestGroupLocMessage responseRequestGroupLocMessage = (ResponseRequestGroupLocMessage) message;
            if (responseRequestGroupLocMessage.hasError()) {
                adVar4 = this.f2577a.d;
                adVar4.a();
                return;
            }
            Iterator<String> iteraotrOfBusinessAreaList = responseRequestGroupLocMessage.getIteraotrOfBusinessAreaList();
            ArrayList arrayList = new ArrayList();
            while (iteraotrOfBusinessAreaList.hasNext()) {
                arrayList.add(iteraotrOfBusinessAreaList.next());
            }
            String position = responseRequestGroupLocMessage.getPosition();
            if ((position == null || position.equals("")) && arrayList.size() < 1) {
                adVar2 = this.f2577a.d;
                adVar2.a();
                return;
            }
            adVar3 = this.f2577a.d;
            d = this.f2577a.b;
            d2 = this.f2577a.f2575a;
            adVar3.a(position, arrayList, d, d2);
        }
    }
}
