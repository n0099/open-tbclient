package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId lfg = BdUniqueId.gen();
    public List<a> dKd;
    public UserData mUserData;

    /* loaded from: classes16.dex */
    public static class a {
        public int lfh;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lfg;
    }

    public void eJ(List<a> list) {
        this.dKd = list;
    }
}
