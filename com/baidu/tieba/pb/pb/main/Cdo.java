package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements c.b {
    final /* synthetic */ dn djG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dn dnVar) {
        this.djG = dnVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        View.OnClickListener onClickListener;
        if (cVar != null && view != null) {
            cVar.dismiss();
            onClickListener = this.djG.bis;
            onClickListener.onClick(view);
        }
    }
}
