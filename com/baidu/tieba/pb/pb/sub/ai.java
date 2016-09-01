package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ ag ewi;
    private final /* synthetic */ SparseArray ewj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, SparseArray sparseArray) {
        this.ewi = agVar;
        this.ewj = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.ewi.ewa;
        if (aVar2 != null) {
            aVar3 = this.ewi.ewa;
            aVar3.g(new Object[]{this.ewj.get(t.g.tag_del_post_id), this.ewj.get(t.g.tag_manage_user_identity), this.ewj.get(t.g.tag_del_post_is_self), this.ewj.get(t.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
