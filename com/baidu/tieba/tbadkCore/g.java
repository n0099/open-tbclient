package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseCardInfo implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId njy = BdUniqueId.gen();
    public int njA = -1;
    public List<by> njz;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return njy;
    }
}
