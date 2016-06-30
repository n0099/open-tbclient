package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.y;
import tbclient.User;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eii = BdUniqueId.gen();
    private y profitData;
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            y yVar = new y();
            yVar.a(user.tw_anchor_info);
            yVar.o(user.profit_list);
            a(yVar);
        }
    }

    public void a(y yVar) {
        this.profitData = yVar;
    }

    public y aLi() {
        return this.profitData;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eii;
    }
}
