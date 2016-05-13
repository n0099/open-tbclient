package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.k;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class a implements k.a {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.tieba.usermute.k.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        y yVar;
        boolean z;
        y yVar2;
        yVar = this.dqn.dqe;
        yVar.azA();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(t.g.tag_user_mute_visible, true);
            sparseArray.put(t.g.tag_user_mute_msg, dataRes.mute_confirm);
            z = z2;
        } else {
            sparseArray.put(t.g.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = sparseArray.get(t.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(t.g.tag_from)).intValue() : 0;
        if (intValue != 0) {
            if (intValue == 1) {
                yVar2 = this.dqn.dqe;
                yVar2.a(sparseArray, z);
                return;
            }
            return;
        }
        this.dqn.a(z, sparseArray);
    }
}
