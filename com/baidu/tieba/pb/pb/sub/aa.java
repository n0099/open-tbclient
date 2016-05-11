package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.b {
    final /* synthetic */ y dqN;
    private final /* synthetic */ SparseArray dqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, SparseArray sparseArray) {
        this.dqN = yVar;
        this.dqO = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.dqN.dqH;
        if (aVar2 != null) {
            aVar3 = this.dqN.dqH;
            aVar3.d(new Object[]{this.dqO.get(t.g.tag_del_post_id), this.dqO.get(t.g.tag_manage_user_identity), this.dqO.get(t.g.tag_del_post_is_self), this.dqO.get(t.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
