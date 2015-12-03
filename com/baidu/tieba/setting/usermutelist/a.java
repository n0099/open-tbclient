package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements m.a {
    final /* synthetic */ UserMuteListActivity doY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.doY = userMuteListActivity;
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
        bVar = this.doY.aQC;
        bVar.ay(false);
        if (i != m.dpf) {
            lVar = this.doY.doQ;
            lVar.showNoData();
            this.doY.showToast(str);
            return;
        }
        this.doY.XX = arrayList;
        arrayList2 = this.doY.XX;
        if (arrayList2 != null) {
            arrayList3 = this.doY.XX;
            if (arrayList3.size() > 0) {
                hVar = this.doY.doR;
                arrayList4 = this.doY.XX;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.doY.doQ;
        lVar2.showNoData();
    }
}
