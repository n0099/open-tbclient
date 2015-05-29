package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ s bPT;
    private final /* synthetic */ SparseArray bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(s sVar, SparseArray sparseArray) {
        this.bPT = sVar;
        this.bPV = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        r rVar;
        r rVar2;
        rVar = this.bPT.bPK;
        if (rVar != null) {
            rVar2 = this.bPT.bPK;
            rVar2.c(new Object[]{this.bPV.get(com.baidu.tieba.q.tag_del_post_id), this.bPV.get(com.baidu.tieba.q.tag_manage_user_identity), this.bPV.get(com.baidu.tieba.q.tag_del_post_is_self), this.bPV.get(com.baidu.tieba.q.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
