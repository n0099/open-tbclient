package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes23.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId mdF = BdUniqueId.gen();
    public List<f> mdG;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdF;
    }
}
