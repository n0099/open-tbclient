package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.widget.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements p {
    final /* synthetic */ d ccu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.ccu = dVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        AccountData currentAccountObj;
        c cVar;
        if (z && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && currentAccountObj.getMemberIconUrl() != null && currentAccountObj.getMemberIconUrl().equals(str)) {
            cVar = this.ccu.ccq;
            cVar.eG(true);
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }
}
