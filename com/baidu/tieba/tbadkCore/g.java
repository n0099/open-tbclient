package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lDB = BdUniqueId.gen();
    public List<bu> lDC;
    public int lDD = -1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lDB;
    }
}
