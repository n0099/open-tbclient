package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eMz = BdUniqueId.gen();
    public boolean bld;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eMz;
    }
}
