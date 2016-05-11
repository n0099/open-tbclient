package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements c.b {
    final /* synthetic */ dd dlZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.dlZ = ddVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.dlZ.ber;
            onClickListener.onClick(view);
        }
    }
}
