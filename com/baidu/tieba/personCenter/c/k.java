package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes21.dex */
public class k extends BaseCardInfo implements q {
    public static BdUniqueId lWv = BdUniqueId.gen();
    private List<c> lWw;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lWv;
    }

    public void setData(List<c> list) {
        this.lWw = list;
    }

    public List<c> getData() {
        return this.lWw;
    }
}
