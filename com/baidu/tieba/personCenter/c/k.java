package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class k extends BaseCardInfo implements q {
    public static BdUniqueId mkE = BdUniqueId.gen();
    private List<c> mkF;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mkE;
    }

    public void setData(List<c> list) {
        this.mkF = list;
    }

    public List<c> getData() {
        return this.mkF;
    }
}
