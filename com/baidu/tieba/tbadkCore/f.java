package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId hfA = BdUniqueId.gen();
    public List<be> hfB;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return hfA;
    }
}
