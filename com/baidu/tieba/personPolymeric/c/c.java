package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgU = BdUniqueId.gen();
    public List<f> fgV;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgU;
    }
}
