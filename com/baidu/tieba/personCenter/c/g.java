package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId lPT = BdUniqueId.gen();
    public List<a> egJ;
    public UserData mUserData;

    /* loaded from: classes22.dex */
    public static class a {
        public int lPU;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lPT;
    }

    public void fd(List<a> list) {
        this.egJ = list;
    }
}
