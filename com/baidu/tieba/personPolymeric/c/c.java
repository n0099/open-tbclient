package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId mxb = BdUniqueId.gen();
    public List<f> mxc;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mxb;
    }
}
