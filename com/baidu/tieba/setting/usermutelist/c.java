package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ UserMuteListActivity cPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(UserMuteListActivity userMuteListActivity, int i) {
        super(i);
        this.cPg = userMuteListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0046: IGET  (r1v15 java.lang.Long A[REMOVE]) = (r1v13 tbclient.UserMuteQuery.MuteUser) tbclient.UserMuteQuery.MuteUser.user_id java.lang.Long)] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        h hVar;
        ArrayList arrayList6;
        l lVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            arrayList = this.cPg.Xh;
            if (arrayList != null) {
                arrayList2 = this.cPg.Xh;
                if (arrayList2.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        arrayList3 = this.cPg.Xh;
                        if (i2 < arrayList3.size()) {
                            arrayList4 = this.cPg.Xh;
                            MuteUser muteUser = (MuteUser) arrayList4.get(i2);
                            if (muteUser != null && new StringBuilder().append(muteUser.user_id).toString().equals(str)) {
                                arrayList5 = this.cPg.Xh;
                                arrayList5.remove(i2);
                                hVar = this.cPg.cOZ;
                                hVar.notifyDataSetChanged();
                                arrayList6 = this.cPg.Xh;
                                if (arrayList6.size() == 0) {
                                    lVar = this.cPg.cOY;
                                    lVar.showNoData();
                                    return;
                                }
                                return;
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
