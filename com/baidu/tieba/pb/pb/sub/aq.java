package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ ao erD;
    private final /* synthetic */ SparseArray erE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, SparseArray sparseArray) {
        this.erD = aoVar;
        this.erE = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.erD.ers;
        if (aVar2 != null) {
            aVar3 = this.erD.ers;
            aVar3.g(new Object[]{this.erE.get(w.h.tag_del_post_id), this.erE.get(w.h.tag_manage_user_identity), this.erE.get(w.h.tag_del_post_is_self), this.erE.get(w.h.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
