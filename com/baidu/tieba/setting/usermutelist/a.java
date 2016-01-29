package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity dMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.dMp = userMuteListActivity;
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
        bVar = this.dMp.aWB;
        bVar.aw(false);
        if (i != m.dMw) {
            lVar = this.dMp.dMh;
            lVar.Ri();
            this.dMp.showToast(str);
            return;
        }
        this.dMp.YX = arrayList;
        arrayList2 = this.dMp.YX;
        if (arrayList2 != null) {
            arrayList3 = this.dMp.YX;
            if (arrayList3.size() > 0) {
                hVar = this.dMp.dMi;
                arrayList4 = this.dMp.YX;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.dMp.dMh;
        lVar2.Ri();
    }
}
