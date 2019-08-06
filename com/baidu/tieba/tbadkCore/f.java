package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jdS = BdUniqueId.gen();
    public List<bh> jdT;
    public int jdU = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jdS;
    }
}
