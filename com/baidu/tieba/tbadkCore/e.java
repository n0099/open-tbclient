package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId hle = BdUniqueId.gen();
    public List<bb> hlf;
    public int hlg = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hle;
    }
}
