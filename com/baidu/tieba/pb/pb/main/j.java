package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class j implements i.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        dk dkVar;
        boolean z;
        dk dkVar2;
        dkVar = this.cFS.cFq;
        dkVar.ang();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(n.g.tag_user_mute_visible, true);
            z = z2;
        } else {
            sparseArray.put(n.g.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = ((Integer) sparseArray.get(n.g.tag_from)).intValue();
        if (intValue == 0) {
            this.cFS.a(z, sparseArray);
        } else if (intValue == 1) {
            dkVar2 = this.cFS.cFq;
            dkVar2.a(sparseArray, z);
        }
    }
}
