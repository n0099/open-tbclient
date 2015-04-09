package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ k caP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.caP = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        int i2;
        eVar.dismiss();
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        com.baidu.tbadk.core.n.px().bj(i2);
        this.caP.hY(i2);
        this.caP.agO();
        be.sY().th();
    }
}
