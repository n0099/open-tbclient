package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes11.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ksT = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.o> ksU;
    public long uid;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ksT;
    }
}
