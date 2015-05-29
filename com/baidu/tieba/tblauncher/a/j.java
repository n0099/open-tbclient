package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.widget.n {
    final /* synthetic */ d cwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.cwD = dVar;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        AccountData currentAccountObj;
        c cVar;
        if (z && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && currentAccountObj.getMemberIconUrl() != null && currentAccountObj.getMemberIconUrl().equals(str)) {
            cVar = this.cwD.cwz;
            cVar.ft(true);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
    }
}
