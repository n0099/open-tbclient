package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gyq = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.h> gyr;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gyq;
    }
}
