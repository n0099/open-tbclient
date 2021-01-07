package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId mpM = BdUniqueId.gen();
    private List<c> mpN;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mpM;
    }

    public void setData(List<c> list) {
        this.mpN = list;
    }

    public List<c> getData() {
        return this.mpN;
    }
}
