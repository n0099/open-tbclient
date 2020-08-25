package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes18.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lmy = BdUniqueId.gen();
    public List<f> lmz;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmy;
    }
}
