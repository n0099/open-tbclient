package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class a implements i.a {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        w wVar;
        boolean z;
        w wVar2;
        wVar = this.cTK.cTB;
        wVar.arE();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(t.g.tag_user_mute_visible, true);
            z = z2;
        } else {
            sparseArray.put(t.g.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = sparseArray.get(t.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(t.g.tag_from)).intValue() : 0;
        if (intValue != 0) {
            if (intValue == 1) {
                wVar2 = this.cTK.cTB;
                wVar2.a(sparseArray, z);
                return;
            }
            return;
        }
        this.cTK.a(z, sparseArray);
    }
}
