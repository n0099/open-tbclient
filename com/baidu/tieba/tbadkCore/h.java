package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseCardInfo implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId njB = BdUniqueId.gen();
    public List<by> njC;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return njB;
    }
}
