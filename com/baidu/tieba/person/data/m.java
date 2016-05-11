package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.w;
import tbclient.User;
/* loaded from: classes.dex */
public class m implements v {
    public static final BdUniqueId dzE = BdUniqueId.gen();
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
            wVar.n(user.profit_list);
            a(wVar);
        }
    }

    public void a(w wVar) {
        this.profitData = wVar;
    }

    public w aCm() {
        return this.profitData;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzE;
    }
}
