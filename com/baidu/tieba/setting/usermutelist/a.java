package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity dwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.dwl = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.m.a
    public void a(ArrayList<MuteUser> arrayList, int i, String str) {
        com.baidu.tbadk.core.view.b bVar;
        l lVar;
        ArrayList arrayList2;
        l lVar2;
        ArrayList arrayList3;
        h hVar;
        ArrayList<MuteUser> arrayList4;
        bVar = this.dwl.aUt;
        bVar.av(false);
        if (i != m.dws) {
            lVar = this.dwl.dwd;
            lVar.showNoData();
            this.dwl.showToast(str);
            return;
        }
        this.dwl.YA = arrayList;
        arrayList2 = this.dwl.YA;
        if (arrayList2 != null) {
            arrayList3 = this.dwl.YA;
            if (arrayList3.size() > 0) {
                hVar = this.dwl.dwe;
                arrayList4 = this.dwl.YA;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.dwl.dwd;
        lVar2.showNoData();
    }
}
