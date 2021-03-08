package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes7.dex */
public class j extends BaseCardInfo {
    public static final BdUniqueId mEd = BdUniqueId.gen();
    public boolean iDw;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mEd;
    }
}
