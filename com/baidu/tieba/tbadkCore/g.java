package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseCardInfo implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mVy = BdUniqueId.gen();
    public int mVA = -1;
    public List<bx> mVz;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mVy;
    }
}
