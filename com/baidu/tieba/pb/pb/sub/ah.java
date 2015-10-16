package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    final /* synthetic */ t cmX;
    private final /* synthetic */ SparseArray cna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(t tVar, SparseArray sparseArray) {
        this.cmX = tVar;
        this.cna = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.cmX.cmQ;
        if (aVar2 != null) {
            aVar3 = this.cmX.cmQ;
            aVar3.d(new Object[]{this.cna.get(i.f.tag_del_post_id), this.cna.get(i.f.tag_manage_user_identity), this.cna.get(i.f.tag_del_post_is_self), this.cna.get(i.f.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
