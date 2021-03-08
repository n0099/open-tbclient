package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId mDR = BdUniqueId.gen();
    public List<f> mDS;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mDR;
    }
}
