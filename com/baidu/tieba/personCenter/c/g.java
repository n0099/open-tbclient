package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId lVP = BdUniqueId.gen();
    public List<a> emA;
    public UserData mUserData;

    /* loaded from: classes22.dex */
    public static class a {
        public int lVQ;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lVP;
    }

    public void fl(List<a> list) {
        this.emA = list;
    }
}
