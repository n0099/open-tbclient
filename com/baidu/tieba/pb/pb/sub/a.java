package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.i;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
class a implements i.a {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tieba.usermute.i.a
    public void a(DataRes dataRes, int i, String str, Object obj) {
        v vVar;
        boolean z;
        v vVar2;
        vVar = this.cnS.cnJ;
        vVar.ahu();
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
                vVar2 = this.cnS.cnJ;
                vVar2.a(sparseArray, z);
                return;
            }
            return;
        }
        this.cnS.a(z, sparseArray);
    }
}
