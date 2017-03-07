package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHK = BdUniqueId.gen();
    public int eHL;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingTop;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHK;
    }
}
