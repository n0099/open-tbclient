package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEk = BdUniqueId.gen();
    public List<v> eEl;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eEk;
    }
}
