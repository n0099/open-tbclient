package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class i implements i.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        da daVar;
        boolean z;
        da daVar2;
        daVar = this.cCm.cBL;
        daVar.alU();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(n.f.tag_user_mute_visible, true);
            z = z2;
        } else {
            sparseArray.put(n.f.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = ((Integer) sparseArray.get(n.f.tag_from)).intValue();
        if (intValue == 0) {
            this.cCm.a(z, sparseArray);
        } else if (intValue == 1) {
            daVar2 = this.cCm.cBL;
            daVar2.a(sparseArray, z);
        }
    }
}
