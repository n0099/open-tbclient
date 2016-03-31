package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements c.b {
    private final /* synthetic */ int cXD;
    private final /* synthetic */ com.baidu.tbadk.data.h dDh;
    private final /* synthetic */ List dDi;
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(f fVar, com.baidu.tbadk.data.h hVar, List list, int i) {
        this.this$0 = fVar;
        this.dDh = hVar;
        this.dDi = list;
        this.cXD = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.this$0.dCE = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.this$0.aCN();
                }
            } else {
                this.this$0.aCM();
            }
        } else {
            this.this$0.d(this.dDh, this.dDi, this.cXD);
        }
        cVar.dismiss();
    }
}
