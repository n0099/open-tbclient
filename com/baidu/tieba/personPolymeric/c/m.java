package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes11.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kaX = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.m> kaY;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kaX;
    }
}
