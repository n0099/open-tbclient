package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements am {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.am
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.c cVar) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        ak akVar;
        s sVar5;
        sVar = this.bPx.bPr;
        if (sVar != null) {
            sVar5 = this.bPx.bPr;
            sVar5.ado();
        }
        if (z) {
            sVar2 = this.bPx.bPr;
            sVar2.hideNoDataView();
            if (cVar != null) {
                sVar3 = this.bPx.bPr;
                if (sVar3 != null) {
                    sVar4 = this.bPx.bPr;
                    akVar = this.bPx.bPo;
                    sVar4.a(cVar, akVar.aaw());
                }
                an anVar = new an();
                anVar.setData(cVar);
                anVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, anVar));
                return;
            }
            return;
        }
        this.bPx.showToast(str);
        this.bPx.acW();
    }
}
