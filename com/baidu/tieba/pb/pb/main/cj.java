package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements c.b {
    final /* synthetic */ ci cDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar) {
        this.cDM = ciVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.cDM.aXv;
            onClickListener.onClick(view);
        }
    }
}
