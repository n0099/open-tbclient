package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    final /* synthetic */ t chq;
    private final /* synthetic */ SparseArray cht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(t tVar, SparseArray sparseArray) {
        this.chq = tVar;
        this.cht = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.chq.chj;
        if (aVar2 != null) {
            aVar3 = this.chq.chj;
            aVar3.d(new Object[]{this.cht.get(i.f.tag_del_post_id), this.cht.get(i.f.tag_manage_user_identity), this.cht.get(i.f.tag_del_post_is_self), this.cht.get(i.f.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
