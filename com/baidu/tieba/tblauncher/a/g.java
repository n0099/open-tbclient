package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.widget.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements p {
    final /* synthetic */ d cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.cdM = dVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        AccountData currentAccountObj;
        c cVar;
        if (z && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && currentAccountObj.getMemberIconUrl() != null && currentAccountObj.getMemberIconUrl().equals(str)) {
            cVar = this.cdM.cdI;
            cVar.eL(true);
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }
}
