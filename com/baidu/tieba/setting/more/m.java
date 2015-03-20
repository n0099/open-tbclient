package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ k caA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.caA = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        switch (i) {
            case 0:
                com.baidu.tbadk.core.n.px().Y(true);
                com.baidu.tbadk.core.n.px().bk(0);
                break;
            case 1:
                com.baidu.tbadk.core.n.px().Y(true);
                com.baidu.tbadk.core.n.px().bk(1);
                break;
            case 2:
                com.baidu.tbadk.core.n.px().Y(true);
                com.baidu.tbadk.core.n.px().bk(2);
                break;
            case 3:
                com.baidu.tbadk.core.n.px().Y(false);
                break;
        }
        this.caA.agA();
        this.caA.agz();
    }
}
