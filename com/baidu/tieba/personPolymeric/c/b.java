package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eua = BdUniqueId.gen();
    public List<e> eub;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eua;
    }
}
