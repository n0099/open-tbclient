package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements c.b {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        this.this$0.dFL = false;
        if (i != 0) {
            if (i == 1) {
                this.this$0.aDh();
            }
        } else {
            this.this$0.aDg();
        }
        cVar.dismiss();
    }
}
