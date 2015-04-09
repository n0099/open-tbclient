package com.baidu.tieba.setting.more;

import android.view.View;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ k caP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.caP = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        switch (i) {
            case 0:
                com.baidu.tbadk.core.n.px().bi(0);
                break;
            case 1:
                com.baidu.tbadk.core.n.px().bi(1);
                break;
            case 2:
                com.baidu.tbadk.core.n.px().bi(2);
                break;
        }
        this.caP.agR();
        this.caP.agO();
    }
}
