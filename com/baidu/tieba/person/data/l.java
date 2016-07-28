package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ab;
import tbclient.User;
/* loaded from: classes.dex */
public class l implements v {
    public static final BdUniqueId esm = BdUniqueId.gen();
    private ab profitData;
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            ab abVar = new ab();
            abVar.a(user.tw_anchor_info);
            abVar.o(user.profit_list);
            a(abVar);
        }
    }

    public void a(ab abVar) {
        this.profitData = abVar;
    }

    public ab aNL() {
        return this.profitData;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esm;
    }
}
