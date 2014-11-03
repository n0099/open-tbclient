package com.baidu.tieba.mygiftlist;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ MyGiftListActivity bto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyGiftListActivity myGiftListActivity) {
        this.bto = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        k kVar;
        j jVar;
        j jVar2;
        if (!com.baidu.adp.lib.util.m.isNetOk()) {
            kVar = this.bto.bti;
            kVar.VN();
            return;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oS();
        jVar = this.bto.bth;
        jVar.dR(false);
        jVar2 = this.bto.bth;
        jVar2.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bto.btk);
    }
}
