package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity eeP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.eeP = userMuteListActivity;
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
        bVar = this.eeP.bbk;
        bVar.ay(false);
        if (i != m.eeW) {
            lVar = this.eeP.eeH;
            lVar.SV();
            this.eeP.showToast(str);
            return;
        }
        this.eeP.Xq = arrayList;
        arrayList2 = this.eeP.Xq;
        if (arrayList2 != null) {
            arrayList3 = this.eeP.Xq;
            if (arrayList3.size() > 0) {
                hVar = this.eeP.eeI;
                arrayList4 = this.eeP.Xq;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.eeP.eeH;
        lVar2.SV();
    }
}
