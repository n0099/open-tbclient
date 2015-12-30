package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    final /* synthetic */ w cLC;
    private final /* synthetic */ SparseArray cLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, SparseArray sparseArray) {
        this.cLC = wVar;
        this.cLD = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.cLC.cLv;
        if (aVar2 != null) {
            aVar3 = this.cLC.cLv;
            aVar3.d(new Object[]{this.cLD.get(n.g.tag_del_post_id), this.cLD.get(n.g.tag_manage_user_identity), this.cLD.get(n.g.tag_del_post_is_self), this.cLD.get(n.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
