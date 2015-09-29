package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity cOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.cOH = userMuteListActivity;
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
        aVar = this.cOH.aLD;
        aVar.av(false);
        if (i != m.cOO) {
            lVar = this.cOH.cOz;
            lVar.showNoData();
            this.cOH.showToast(str);
            return;
        }
        this.cOH.Xf = arrayList;
        arrayList2 = this.cOH.Xf;
        if (arrayList2 != null) {
            arrayList3 = this.cOH.Xf;
            if (arrayList3.size() > 0) {
                hVar = this.cOH.cOA;
                arrayList4 = this.cOH.Xf;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.cOH.cOz;
        lVar2.showNoData();
    }
}
