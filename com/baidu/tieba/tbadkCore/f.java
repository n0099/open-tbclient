package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iDC = BdUniqueId.gen();
    public List<bg> iDD;
    public int iDE = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iDC;
    }
}
