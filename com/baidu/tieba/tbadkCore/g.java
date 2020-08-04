package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lKS = BdUniqueId.gen();
    public List<bv> lKT;
    public int lKU = -1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lKS;
    }
}
