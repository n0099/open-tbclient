package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class l implements i.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        dz dzVar;
        boolean z;
        dz dzVar2;
        dzVar = this.cNq.cMK;
        dzVar.arE();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(t.g.tag_user_mute_visible, true);
            z = z2;
        } else {
            sparseArray.put(t.g.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = ((Integer) sparseArray.get(t.g.tag_from)).intValue();
        if (intValue == 0) {
            this.cNq.a(z, sparseArray);
        } else if (intValue == 1) {
            dzVar2 = this.cNq.cMK;
            dzVar2.a(sparseArray, z);
        }
    }
}
