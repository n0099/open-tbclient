package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eDc = BdUniqueId.gen();
    public List<e> eDd;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDc;
    }
}
