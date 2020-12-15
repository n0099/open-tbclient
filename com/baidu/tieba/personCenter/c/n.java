package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class n extends BaseCardInfo implements q {
    public static BdUniqueId mkK = BdUniqueId.gen();
    public List<a> mkc = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mkK;
    }
}
