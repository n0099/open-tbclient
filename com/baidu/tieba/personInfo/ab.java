package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements c.b {
    final /* synthetic */ d cSn;
    private final /* synthetic */ com.baidu.tbadk.data.g cSo;
    private final /* synthetic */ List cSp;
    private final /* synthetic */ int ctC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(d dVar, com.baidu.tbadk.data.g gVar, List list, int i) {
        this.cSn = dVar;
        this.cSo = gVar;
        this.cSp = list;
        this.ctC = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.cSn.cRQ = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.cSn.aoI();
                }
            } else {
                this.cSn.aoH();
            }
        } else {
            this.cSn.d(this.cSo, this.cSp, this.ctC);
        }
        cVar.dismiss();
    }
}
