package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId mpT = BdUniqueId.gen();
    public List<a> mpl = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mpT;
    }
}
