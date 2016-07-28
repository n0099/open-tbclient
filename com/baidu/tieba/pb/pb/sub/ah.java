package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    final /* synthetic */ af eka;
    private final /* synthetic */ SparseArray ekb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, SparseArray sparseArray) {
        this.eka = afVar;
        this.ekb = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.eka.ejS;
        if (aVar2 != null) {
            aVar3 = this.eka.ejS;
            aVar3.g(new Object[]{this.ekb.get(u.g.tag_del_post_id), this.ekb.get(u.g.tag_manage_user_identity), this.ekb.get(u.g.tag_del_post_is_self), this.ekb.get(u.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
