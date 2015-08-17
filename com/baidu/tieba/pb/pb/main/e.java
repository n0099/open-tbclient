package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class e implements i.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        cb cbVar;
        boolean z;
        cb cbVar2;
        cbVar = this.cbo.caQ;
        cbVar.aeG();
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
            this.cbo.a(z, sparseArray);
        } else if (intValue == 1) {
            cbVar2 = this.cbo.caQ;
            cbVar2.a(sparseArray, z);
        }
    }
}
