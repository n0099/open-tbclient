package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId gXy = BdUniqueId.gen();
    public List<bd> gXz;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXy;
    }
}
