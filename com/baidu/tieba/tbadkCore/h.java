package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lDE = BdUniqueId.gen();
    public List<bu> lDF;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lDE;
    }
}
