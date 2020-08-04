package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId kPq = BdUniqueId.gen();
    public List<a> dAT;
    public UserData mUserData;

    /* loaded from: classes16.dex */
    public static class a {
        public int kPr;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kPq;
    }

    public void eB(List<a> list) {
        this.dAT = list;
    }
}
