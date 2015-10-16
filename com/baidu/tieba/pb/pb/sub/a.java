package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class a implements i.a {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        t tVar;
        boolean z;
        t tVar2;
        tVar = this.cmC.cmv;
        tVar.agS();
        SparseArray<Object> sparseArray = (SparseArray) obj;
        if (i == 0 && dataRes != null) {
            boolean z2 = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0) == 1;
            sparseArray.put(i.f.tag_display_reply_visible, true);
            z = z2;
        } else {
            sparseArray.put(i.f.tag_display_reply_visible, false);
            z = false;
        }
        int intValue = sparseArray.get(i.f.tag_from) instanceof Integer ? ((Integer) sparseArray.get(i.f.tag_from)).intValue() : 0;
        if (intValue != 0) {
            if (intValue == 1) {
                tVar2 = this.cmC.cmv;
                tVar2.a(sparseArray, z);
                return;
            }
            return;
        }
        this.cmC.a(z, sparseArray);
    }
}
