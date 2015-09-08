package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.usermute.k;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements k.a {
    final /* synthetic */ UserMuteListActivity cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.cHG = userMuteListActivity;
    }

    @Override // com.baidu.tieba.usermute.k.a
    public void a(ArrayList<MuteUser> arrayList, int i, String str) {
        com.baidu.tbadk.core.view.a aVar;
        l lVar;
        ArrayList arrayList2;
        l lVar2;
        ArrayList arrayList3;
        h hVar;
        ArrayList<MuteUser> arrayList4;
        aVar = this.cHG.aMI;
        aVar.av(false);
        if (i != com.baidu.tieba.usermute.k.cXF) {
            lVar = this.cHG.cHy;
            lVar.showNoData();
            this.cHG.showToast(str);
            return;
        }
        this.cHG.Xn = arrayList;
        arrayList2 = this.cHG.Xn;
        if (arrayList2 != null) {
            arrayList3 = this.cHG.Xn;
            if (arrayList3.size() > 0) {
                hVar = this.cHG.cHz;
                arrayList4 = this.cHG.Xn;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.cHG.cHy;
        lVar2.showNoData();
    }
}
