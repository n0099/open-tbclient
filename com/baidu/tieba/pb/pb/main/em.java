package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements c.b {
    final /* synthetic */ el eqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(el elVar) {
        this.eqt = elVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.eqt.bTd;
            onClickListener.onClick(view);
        }
    }
}
