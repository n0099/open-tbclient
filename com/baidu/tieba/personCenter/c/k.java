package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId muy = BdUniqueId.gen();
    private List<c> muz;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return muy;
    }

    public void setData(List<c> list) {
        this.muz = list;
    }

    public List<c> getData() {
        return this.muz;
    }
}
