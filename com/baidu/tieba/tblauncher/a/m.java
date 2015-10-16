package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TbImageView.a {
    final /* synthetic */ e ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.ddY = eVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        AccountData currentAccountObj;
        d dVar;
        if (z && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && currentAccountObj.getMemberIconUrl() != null && currentAccountObj.getMemberIconUrl().equals(str)) {
            dVar = this.ddY.ddS;
            dVar.gG(true);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
