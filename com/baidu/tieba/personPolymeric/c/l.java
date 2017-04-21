package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHX = BdUniqueId.gen();
    public List<v> eHY;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHX;
    }
}
