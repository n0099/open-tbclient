package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ v coo;
    private final /* synthetic */ SparseArray cor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(v vVar, SparseArray sparseArray) {
        this.coo = vVar;
        this.cor = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.coo.coh;
        if (aVar2 != null) {
            aVar3 = this.coo.coh;
            aVar3.d(new Object[]{this.cor.get(i.f.tag_del_post_id), this.cor.get(i.f.tag_manage_user_identity), this.cor.get(i.f.tag_del_post_is_self), this.cor.get(i.f.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
