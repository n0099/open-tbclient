package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.usermute.k;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class a implements k.a {
    final /* synthetic */ UserMuteListActivity czi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UserMuteListActivity userMuteListActivity) {
        this.czi = userMuteListActivity;
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
        aVar = this.czi.aMv;
        aVar.av(false);
        if (i != com.baidu.tieba.usermute.k.cOY) {
            lVar = this.czi.cza;
            lVar.showNoData();
            this.czi.showToast(str);
            return;
        }
        this.czi.Xe = arrayList;
        arrayList2 = this.czi.Xe;
        if (arrayList2 != null) {
            arrayList3 = this.czi.Xe;
            if (arrayList3.size() > 0) {
                hVar = this.czi.czb;
                arrayList4 = this.czi.Xe;
                hVar.setData(arrayList4);
                return;
            }
        }
        lVar2 = this.czi.cza;
        lVar2.showNoData();
    }
}
