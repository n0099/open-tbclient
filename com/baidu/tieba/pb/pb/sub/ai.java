package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ ag eyq;
    private final /* synthetic */ SparseArray eyr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, SparseArray sparseArray) {
        this.eyq = agVar;
        this.eyr = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.eyq.eyh;
        if (aVar2 != null) {
            aVar3 = this.eyq.eyh;
            aVar3.g(new Object[]{this.eyr.get(r.g.tag_del_post_id), this.eyr.get(r.g.tag_manage_user_identity), this.eyr.get(r.g.tag_del_post_is_self), this.eyr.get(r.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
