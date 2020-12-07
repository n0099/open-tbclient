package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes24.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId mrL = BdUniqueId.gen();
    public List<f> mrM;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrL;
    }
}
