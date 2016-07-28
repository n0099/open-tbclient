package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements c.b {
    final /* synthetic */ Cdo eee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(Cdo cdo) {
        this.eee = cdo;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.eee.bCU;
            onClickListener.onClick(view);
        }
    }
}
