package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId nuH = BdUniqueId.gen();
    public List<cb> nuI;
    public int nuJ = -1;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nuH;
    }
}
