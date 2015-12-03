package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ w cHA;
    private final /* synthetic */ SparseArray cHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(w wVar, SparseArray sparseArray) {
        this.cHA = wVar;
        this.cHD = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.cHA.cHt;
        if (aVar2 != null) {
            aVar3 = this.cHA.cHt;
            aVar3.d(new Object[]{this.cHD.get(n.f.tag_del_post_id), this.cHD.get(n.f.tag_manage_user_identity), this.cHD.get(n.f.tag_del_post_is_self), this.cHD.get(n.f.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
