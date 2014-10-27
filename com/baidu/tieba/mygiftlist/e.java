package com.baidu.tieba.mygiftlist;

import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ MyGiftListActivity bsZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyGiftListActivity myGiftListActivity) {
        this.bsZ = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        k kVar;
        j jVar;
        j jVar2;
        if (!com.baidu.adp.lib.util.m.isNetOk()) {
            kVar = this.bsZ.bsU;
            kVar.VK();
            return;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oQ();
        jVar = this.bsZ.bsT;
        jVar.dR(false);
        jVar2 = this.bsZ.bsT;
        jVar2.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bsZ.bsW);
    }
}
