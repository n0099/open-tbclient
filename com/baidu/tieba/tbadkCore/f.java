package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jgn = BdUniqueId.gen();
    public List<bh> jgo;
    public int jgp = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgn;
    }
}
