package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ s bPU;
    private final /* synthetic */ SparseArray bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(s sVar, SparseArray sparseArray) {
        this.bPU = sVar;
        this.bPW = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        r rVar2;
        rVar = this.bPU.bPL;
        if (rVar != null) {
            rVar2 = this.bPU.bPL;
            rVar2.c(new Object[]{this.bPW.get(com.baidu.tieba.q.tag_del_post_id), this.bPW.get(com.baidu.tieba.q.tag_manage_user_identity), this.bPW.get(com.baidu.tieba.q.tag_del_post_is_self), this.bPW.get(com.baidu.tieba.q.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
