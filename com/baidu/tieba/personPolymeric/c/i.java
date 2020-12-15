package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes24.dex */
public class i extends BaseCardInfo {
    public static final BdUniqueId mrY = BdUniqueId.gen();
    public boolean isHost;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrY;
    }
}
