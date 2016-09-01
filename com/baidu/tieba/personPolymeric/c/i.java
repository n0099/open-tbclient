package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eIk = BdUniqueId.gen();
    public boolean eIl = true;
    public boolean eIm = true;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eIk;
    }
}
