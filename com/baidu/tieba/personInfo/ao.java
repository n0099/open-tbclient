package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements c.b {
    private final /* synthetic */ int dEB;
    private final /* synthetic */ com.baidu.tbadk.data.k eBi;
    private final /* synthetic */ List eBj;
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(h hVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.this$0 = hVar;
        this.eBi = kVar;
        this.eBj = list;
        this.dEB = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.this$0.d(this.eBi, this.eBj, this.dEB);
                }
            } else {
                this.this$0.a(this.eBi);
            }
        } else {
            this.this$0.c(this.eBi, this.eBj, this.dEB);
        }
        cVar.dismiss();
    }
}
