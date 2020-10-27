package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class n extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId lQm = BdUniqueId.gen();
    public List<a> lPF = new ArrayList();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lQm;
    }
}
