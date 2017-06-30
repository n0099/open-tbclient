package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWy = BdUniqueId.gen();
    public List<f> eWz;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eWy;
    }
}
