package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class m extends com.baidu.tieba.card.data.b implements o {
    public static BdUniqueId klK = BdUniqueId.gen();
    public List<a> klh = new ArrayList();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return klK;
    }
}
