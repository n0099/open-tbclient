package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes11.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId joX = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.m> joY;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joX;
    }
}
