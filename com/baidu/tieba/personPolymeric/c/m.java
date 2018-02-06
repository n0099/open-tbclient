package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpV = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.i> gpW;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpV;
    }
}
