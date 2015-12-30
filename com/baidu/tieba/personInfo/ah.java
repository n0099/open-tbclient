package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements c.b {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.cWV.cWt = false;
        if (i != 0) {
            if (i == 1) {
                this.cWV.apS();
            }
        } else {
            this.cWV.apR();
        }
        cVar.dismiss();
    }
}
