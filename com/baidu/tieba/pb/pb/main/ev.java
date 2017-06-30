package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ev implements c.b {
    final /* synthetic */ eu ezE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(eu euVar) {
        this.ezE = euVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.ezE.cay;
            onClickListener.onClick(view);
        }
    }
}
