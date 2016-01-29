package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    final /* synthetic */ w cUl;
    private final /* synthetic */ SparseArray cUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, SparseArray sparseArray) {
        this.cUl = wVar;
        this.cUm = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.cUl.cUe;
        if (aVar2 != null) {
            aVar3 = this.cUl.cUe;
            aVar3.d(new Object[]{this.cUm.get(t.g.tag_del_post_id), this.cUm.get(t.g.tag_manage_user_identity), this.cUm.get(t.g.tag_del_post_is_self), this.cUm.get(t.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
