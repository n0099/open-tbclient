package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.diG.dic = false;
        if (i != 0) {
            if (i == 1) {
                this.diG.avh();
            }
        } else {
            this.diG.avg();
        }
        cVar.dismiss();
    }
}
