package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.User;
/* loaded from: classes.dex */
public class l implements u {
    public static final BdUniqueId dbX = BdUniqueId.gen();
    private com.baidu.tbadk.core.data.q profitData;
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
            qVar.a(user.tw_anchor_info);
            qVar.k(user.profit_list);
            a(qVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.profitData = qVar;
    }

    public com.baidu.tbadk.core.data.q auo() {
        return this.profitData;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dbX;
    }
}
