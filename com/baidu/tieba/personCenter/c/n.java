package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class n extends BaseCardInfo implements q {
    public static BdUniqueId lWA = BdUniqueId.gen();
    public List<a> lVT = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lWA;
    }
}
