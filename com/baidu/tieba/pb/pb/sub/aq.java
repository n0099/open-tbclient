package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ ao eFb;
    private final /* synthetic */ SparseArray eFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, SparseArray sparseArray) {
        this.eFb = aoVar;
        this.eFc = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.eFb.eEQ;
        if (aVar2 != null) {
            aVar3 = this.eFb.eEQ;
            aVar3.g(new Object[]{this.eFc.get(r.g.tag_del_post_id), this.eFc.get(r.g.tag_manage_user_identity), this.eFc.get(r.g.tag_del_post_is_self), this.eFc.get(r.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
