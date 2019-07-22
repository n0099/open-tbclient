package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId irg = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.m> irh;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return irg;
    }
}
