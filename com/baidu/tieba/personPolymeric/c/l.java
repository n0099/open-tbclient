package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpR = BdUniqueId.gen();
    public int paddingBottom;
    public int paddingLeft;
    public int paddingTop;
    public int titleId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpR;
    }
}
