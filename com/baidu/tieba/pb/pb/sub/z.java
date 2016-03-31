package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    final /* synthetic */ x dpf;
    private final /* synthetic */ SparseArray dpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, SparseArray sparseArray) {
        this.dpf = xVar;
        this.dpg = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.dpf.doZ;
        if (aVar2 != null) {
            aVar3 = this.dpf.doZ;
            aVar3.d(new Object[]{this.dpg.get(t.g.tag_del_post_id), this.dpg.get(t.g.tag_manage_user_identity), this.dpg.get(t.g.tag_del_post_is_self), this.dpg.get(t.g.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
