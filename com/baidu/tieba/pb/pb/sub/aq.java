package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ ao evV;
    private final /* synthetic */ SparseArray evW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, SparseArray sparseArray) {
        this.evV = aoVar;
        this.evW = sparseArray;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        NewSubPbActivity.a aVar2;
        NewSubPbActivity.a aVar3;
        aVar2 = this.evV.evK;
        if (aVar2 != null) {
            aVar3 = this.evV.evK;
            aVar3.g(new Object[]{this.evW.get(w.h.tag_del_post_id), this.evW.get(w.h.tag_manage_user_identity), this.evW.get(w.h.tag_del_post_is_self), this.evW.get(w.h.tag_del_post_type)});
        }
        aVar.dismiss();
    }
}
