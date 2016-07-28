package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements c.b {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.this$0.eAF = false;
        if (i != 0) {
            if (i == 1) {
                this.this$0.aPk();
            }
        } else {
            this.this$0.aPj();
        }
        cVar.dismiss();
    }
}
