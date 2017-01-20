package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ ao esl;
    private final /* synthetic */ SparseArray esm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, SparseArray sparseArray) {
        this.esl = aoVar;
        this.esm = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.esl.esa;
        if (aVar2 != null) {
            aVar3 = this.esl.esa;
            aVar3.g(new Object[]{this.esm.get(r.h.tag_del_post_id), this.esm.get(r.h.tag_manage_user_identity), this.esm.get(r.h.tag_del_post_is_self), this.esm.get(r.h.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
