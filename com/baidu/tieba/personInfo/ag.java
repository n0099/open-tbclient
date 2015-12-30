package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements c.b {
    final /* synthetic */ d cWV;
    private final /* synthetic */ com.baidu.tbadk.data.g cWW;
    private final /* synthetic */ List cWX;
    private final /* synthetic */ int cxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(d dVar, com.baidu.tbadk.data.g gVar, List list, int i) {
        this.cWV = dVar;
        this.cWW = gVar;
        this.cWX = list;
        this.cxE = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.cWV.cWt = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.cWV.apS();
                }
            } else {
                this.cWV.apR();
            }
        } else {
            this.cWV.d(this.cWW, this.cWX, this.cxE);
        }
        cVar.dismiss();
    }
}
