package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.w;
import tbclient.User;
/* loaded from: classes.dex */
public class l implements u {
    public static final BdUniqueId dwA = BdUniqueId.gen();
    private w profitData;
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            w wVar = new w();
            wVar.a(user.tw_anchor_info);
            wVar.l(user.profit_list);
            a(wVar);
        }
    }

    public void a(w wVar) {
        this.profitData = wVar;
    }

    public w aBU() {
        return this.profitData;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwA;
    }
}
