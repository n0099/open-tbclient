package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class e implements i.a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        cc ccVar;
        boolean z;
        cc ccVar2;
        ccVar = this.ciz.cia;
        ccVar.agS();
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
            this.ciz.a(z, sparseArray);
        } else if (intValue == 1) {
            ccVar2 = this.ciz.cia;
            ccVar2.a(sparseArray, z);
        }
    }
}
