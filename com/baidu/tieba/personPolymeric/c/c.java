package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmg = BdUniqueId.gen();
    public List<f> fmh;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmg;
    }
}
