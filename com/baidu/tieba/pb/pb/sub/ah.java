package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    final /* synthetic */ t cgt;
    private final /* synthetic */ SparseArray cgw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(t tVar, SparseArray sparseArray) {
        this.cgt = tVar;
        this.cgw = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.cgt.cgl;
        if (aVar2 != null) {
            aVar3 = this.cgt.cgl;
            aVar3.d(new Object[]{this.cgw.get(i.f.tag_del_post_id), this.cgw.get(i.f.tag_manage_user_identity), this.cgw.get(i.f.tag_del_post_is_self), this.cgw.get(i.f.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
