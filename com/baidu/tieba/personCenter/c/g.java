package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId kGn = BdUniqueId.gen();
    public List<a> dvd;
    public UserData mUserData;

    /* loaded from: classes9.dex */
    public static class a {
        public int kGo;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kGn;
    }

    public void ev(List<a> list) {
        this.dvd = list;
    }
}
