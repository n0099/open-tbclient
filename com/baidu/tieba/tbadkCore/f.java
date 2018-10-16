package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gZE = BdUniqueId.gen();
    public List<bb> gZF;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gZE;
    }
}
