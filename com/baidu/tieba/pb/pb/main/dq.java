package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements c.b {
    final /* synthetic */ dp eoJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(dp dpVar) {
        this.eoJ = dpVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.eoJ.bOm;
            onClickListener.onClick(view);
        }
    }
}
