package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class e implements i.a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        cb cbVar;
        boolean z;
        cb cbVar2;
        cbVar = this.ccj.cbL;
        cbVar.aeU();
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
            this.ccj.a(z, sparseArray);
        } else if (intValue == 1) {
            cbVar2 = this.ccj.cbL;
            cbVar2.a(sparseArray, z);
        }
    }
}
