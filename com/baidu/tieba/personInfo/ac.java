package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements c.b {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(d dVar) {
        this.cSn = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.cSn.cRQ = false;
        if (i != 0) {
            if (i == 1) {
                this.cSn.aoI();
            }
        } else {
            this.cSn.aoH();
        }
        cVar.dismiss();
    }
}
