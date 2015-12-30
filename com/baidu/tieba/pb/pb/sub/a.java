package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class a implements i.a {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        w wVar;
        boolean z;
        w wVar2;
        wVar = this.cLc.cKT;
        wVar.ang();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(n.g.tag_user_mute_visible, true);
            z = z2;
        } else {
            sparseArray.put(n.g.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = sparseArray.get(n.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(n.g.tag_from)).intValue() : 0;
        if (intValue != 0) {
            if (intValue == 1) {
                wVar2 = this.cLc.cKT;
                wVar2.a(sparseArray, z);
                return;
            }
            return;
        }
        this.cLc.a(z, sparseArray);
    }
}
