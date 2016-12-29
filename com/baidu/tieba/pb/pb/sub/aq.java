package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ ao ejb;
    private final /* synthetic */ SparseArray ejc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, SparseArray sparseArray) {
        this.ejb = aoVar;
        this.ejc = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.ejb.eiQ;
        if (aVar2 != null) {
            aVar3 = this.ejb.eiQ;
            aVar3.g(new Object[]{this.ejc.get(r.g.tag_del_post_id), this.ejc.get(r.g.tag_manage_user_identity), this.ejc.get(r.g.tag_del_post_is_self), this.ejc.get(r.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
