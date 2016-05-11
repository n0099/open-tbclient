package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements c.b {
    private final /* synthetic */ int cUj;
    private final /* synthetic */ com.baidu.tbadk.data.i dGq;
    private final /* synthetic */ List dGr;
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(f fVar, com.baidu.tbadk.data.i iVar, List list, int i) {
        this.this$0 = fVar;
        this.dGq = iVar;
        this.dGr = list;
        this.cUj = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.this$0.dFL = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.this$0.aDh();
                }
            } else {
                this.this$0.aDg();
            }
        } else {
            this.this$0.c(this.dGq, this.dGr, this.cUj);
        }
        cVar.dismiss();
    }
}
