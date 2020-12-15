package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends BaseCardInfo implements q {
    public static BdUniqueId mkq = BdUniqueId.gen();
    public List<a> erW;
    public UserData mUserData;

    /* loaded from: classes22.dex */
    public static class a {
        public int mkr;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mkq;
    }

    public void fx(List<a> list) {
        this.erW = list;
    }
}
