package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements c.b {
    private final /* synthetic */ int dAs;
    private final /* synthetic */ com.baidu.tbadk.data.k epw;
    private final /* synthetic */ List epx;
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(f fVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.this$0 = fVar;
        this.epw = kVar;
        this.epx = list;
        this.dAs = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.this$0.eoP = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.this$0.aMf();
                }
            } else {
                this.this$0.aMe();
            }
        } else {
            this.this$0.c(this.epw, this.epx, this.dAs);
        }
        cVar.dismiss();
    }
}
