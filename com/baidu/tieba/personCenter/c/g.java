package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes21.dex */
public class g extends BaseCardInfo implements q {
    public static BdUniqueId lWh = BdUniqueId.gen();
    public List<a> ekT;
    public UserData mUserData;

    /* loaded from: classes21.dex */
    public static class a {
        public int lWi;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lWh;
    }

    public void fl(List<a> list) {
        this.ekT = list;
    }
}
