package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.k;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class z implements k.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.k.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        eu euVar;
        boolean z;
        eu euVar2;
        euVar = this.dht.dgF;
        euVar.azf();
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
            this.dht.a(z, sparseArray);
        } else if (intValue == 1) {
            euVar2 = this.dht.dgF;
            euVar2.a(sparseArray, z);
        }
    }
}
