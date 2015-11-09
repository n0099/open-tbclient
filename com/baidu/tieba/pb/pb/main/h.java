package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class h implements i.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        ct ctVar;
        boolean z;
        ct ctVar2;
        ctVar = this.cjN.cjo;
        ctVar.ahu();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(i.f.tag_display_reply_visible, true);
            z = z2;
        } else {
            sparseArray.put(i.f.tag_display_reply_visible, false);
            z = false;
        }
        int intValue = ((Integer) sparseArray.get(i.f.tag_from)).intValue();
        if (intValue == 0) {
            this.cjN.a(z, sparseArray);
        } else if (intValue == 1) {
            ctVar2 = this.cjN.cjo;
            ctVar2.a(sparseArray, z);
        }
    }
}
