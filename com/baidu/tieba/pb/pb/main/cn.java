package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements c.b {
    final /* synthetic */ cm cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.cHG = cmVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.cHG.bbv;
            onClickListener.onClick(view);
        }
    }
}
