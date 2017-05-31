package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ ao eyO;
    private final /* synthetic */ SparseArray eyP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, SparseArray sparseArray) {
        this.eyO = aoVar;
        this.eyP = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.eyO.eyD;
        if (aVar2 != null) {
            aVar3 = this.eyO.eyD;
            aVar3.g(new Object[]{this.eyP.get(w.h.tag_del_post_id), this.eyP.get(w.h.tag_manage_user_identity), this.eyP.get(w.h.tag_del_post_is_self), this.eyP.get(w.h.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
