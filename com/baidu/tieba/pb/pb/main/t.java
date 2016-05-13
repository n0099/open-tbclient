package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.k;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class t implements k.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.k.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        el elVar;
        boolean z;
        el elVar2;
        elVar = this.djE.diR;
        elVar.azA();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            int g = com.baidu.adp.lib.h.b.g(dataRes.is_mute, 0);
            String str2 = dataRes.mute_confirm;
            boolean z2 = g == 1;
            if (com.baidu.tbadk.core.util.ay.isEmpty(str2)) {
                sparseArray.put(t.g.tag_user_mute_msg, "确定禁言？");
            } else {
                sparseArray.put(t.g.tag_user_mute_msg, str2);
            }
            sparseArray.put(t.g.tag_user_mute_visible, true);
            z = z2;
        } else {
            sparseArray.put(t.g.tag_user_mute_visible, false);
            z = false;
        }
        int intValue = ((Integer) sparseArray.get(t.g.tag_from)).intValue();
        if (intValue == 0) {
            this.djE.a(z, sparseArray);
        } else if (intValue == 1) {
            elVar2 = this.djE.diR;
            elVar2.a(sparseArray, z);
        }
    }
}
