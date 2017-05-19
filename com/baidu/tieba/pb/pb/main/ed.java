package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ed implements c.b {
    final /* synthetic */ ec ekG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(ec ecVar) {
        this.ekG = ecVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.ekG.bNq;
            onClickListener.onClick(view);
        }
    }
}
