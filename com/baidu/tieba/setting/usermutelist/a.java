package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity cPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.cPg = userMuteListActivity;
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
        aVar = this.cPg.aLO;
        aVar.av(false);
        if (i != m.cPn) {
            lVar = this.cPg.cOY;
            lVar.showNoData();
            this.cPg.showToast(str);
            return;
        }
        this.cPg.Xh = arrayList;
        arrayList2 = this.cPg.Xh;
        if (arrayList2 != null) {
            arrayList3 = this.cPg.Xh;
            if (arrayList3.size() > 0) {
                hVar = this.cPg.cOZ;
                arrayList4 = this.cPg.Xh;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.cPg.cOY;
        lVar2.showNoData();
    }
}
