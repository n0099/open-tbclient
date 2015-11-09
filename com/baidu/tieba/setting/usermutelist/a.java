package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity cQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.cQC = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.m.a
    public void a(ArrayList<MuteUser> arrayList, int i, String str) {
        com.baidu.tbadk.core.view.a aVar;
        l lVar;
        ArrayList arrayList2;
        l lVar2;
        ArrayList arrayList3;
        h hVar;
        ArrayList<MuteUser> arrayList4;
        aVar = this.cQC.aLW;
        aVar.av(false);
        if (i != m.cQJ) {
            lVar = this.cQC.cQu;
            lVar.showNoData();
            this.cQC.showToast(str);
            return;
        }
        this.cQC.Xk = arrayList;
        arrayList2 = this.cQC.Xk;
        if (arrayList2 != null) {
            arrayList3 = this.cQC.Xk;
            if (arrayList3.size() > 0) {
                hVar = this.cQC.cQv;
                arrayList4 = this.cQC.Xk;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.cQC.cQu;
        lVar2.showNoData();
    }
}
