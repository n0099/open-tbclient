package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jdV = BdUniqueId.gen();
    public List<bh> jdW;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jdV;
    }
}
