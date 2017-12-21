package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gyN = BdUniqueId.gen();
    public List<bd> gyO;
    public int gyP = -1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gyN;
    }
}
