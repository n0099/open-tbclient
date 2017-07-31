package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fkB = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.f> fkC;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fkB;
    }
}
