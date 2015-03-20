package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ k caA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.caA = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        switch (i) {
            case 0:
                TbadkCoreApplication.m411getInst().setFontSize(1);
                break;
            case 1:
                TbadkCoreApplication.m411getInst().setFontSize(2);
                break;
            case 2:
                TbadkCoreApplication.m411getInst().setFontSize(3);
                break;
        }
        this.caA.agD();
    }
}
