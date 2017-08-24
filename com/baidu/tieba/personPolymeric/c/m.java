package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmw = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.f> fmx;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmw;
    }
}
